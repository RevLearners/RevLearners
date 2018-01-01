import {Component, OnInit} from '@angular/core';
import {QuestionService} from '../../services/question.service';
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

    attempt: ChallengeAttempt;
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
                    this.attempt = new ChallengeAttempt(
                        -1, this.creds.getUser(), challenge, 0, []
                    );
                },
                console.log
            );
        }
        else {
            this.creds.navigateToLogin(this.router);
        }

    }

    submitAttempt(): void {
        this.questionService.submitAttempt(this.attempt).subscribe(
            (result: ChallengeAttempt) => {
                this.router.navigate([`/reviewChallenge/${result.id}`]);
            },
            console.log
        );
    }

    selectOption(option: QuestionOption, question: Question) {
        for (const opt of question.options) {
            opt.isCorrect = false;
        }
        option.isCorrect = true;
    }
}

