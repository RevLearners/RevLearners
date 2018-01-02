import {Component, OnInit} from '@angular/core';
import {CompletedChallenge, QuestionService} from '../../services/question.service';
import {ActivatedRoute, Router} from '@angular/router';
import {QuestionOption} from '../../model/question-option';
import {Question} from '../../model/question';
import {ChallengeAttempt} from '../../model/challenge-attempt';
import {Challenge} from '../../model/challenge';
import {LoginCredentialsService} from '../../services/login-credentials.service';

@Component({
    selector: 'app-complete-challenge',
    templateUrl: './complete-challenge.component.html',
    styleUrls: ['./complete-challenge.component.css']
})
export class CompleteChallengeComponent implements OnInit {

    challenge: Challenge;
    challengeId: number;


    constructor(private creds: LoginCredentialsService, private questionService: QuestionService,
                private router: Router, private activatedRoute: ActivatedRoute) {
        this.activatedRoute.params.subscribe(params => {
            console.log(params);
            this.challengeId = +(params['id']);
        });
    }

    ngOnInit() {
        // router.navigate does not actually stop execution of the rest of the code,
        // hence the if statement and return value
        if (this.creds.isLoggedIn()) {
            this.questionService.getChallengeById(this.challengeId).subscribe(
                (challenge: Challenge) => {
                    this.challenge = challenge;
                },
                console.log
            );
        }
        else {
            this.creds.navigateToLogin(this.router);
        }

    }

    submitAttempt(): void {
        const answerMap = {};
        for (const quest of this.challenge.quiz.questions) {
            answerMap[quest.id] = quest.options
                .filter(opt => opt.isCorrect)
                .map(opt => opt.id);
        }
        const completedChallenge = new CompletedChallenge(
            this.creds.getUser().id,
            this.challenge.id,
            answerMap
        );

        this.questionService.submitAttempt(completedChallenge).subscribe(
            (result: ChallengeAttempt) => {
                console.log(result);
                this.router.navigate(['/', 'review-challenge', result.id]);
            },
            console.log
        );
    }

    /**
     * keep them mutually exclusive for now
     * @param {QuestionOption} option
     * @param {Question} question
     */
    selectOption(option: QuestionOption, question: Question) {
        for (const opt of question.options) {
            opt.isCorrect = false;
        }
        option.isCorrect = true;
    }
}

