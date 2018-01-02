import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {QuestionService} from '../../services/question.service';
import {Quiz} from '../../model/quiz';
import {User} from '../../model/user';
import {SessionToken} from '../../model/session-token';
import {LoginCredentialsService} from '../../services/login-credentials.service';
import {Router} from '@angular/router';
import {ChallengeAttempt} from "../../model/challenge-attempt";
import {QuestionOption} from "../../model/question-option";
import {Question} from "../../model/question";

@Component({
    selector: 'app-review-quiz',
    templateUrl: './review-challenge.component.html',
    styleUrls: ['./review-challenge.component.css']
})
export class ReviewChallengeComponent implements OnInit {

    attempt: ChallengeAttempt;

    constructor(private questionService: QuestionService, private activatedRoute: ActivatedRoute,
                private creds: LoginCredentialsService, private rout: Router) {
    }


    ngOnInit() {
        if (this.creds.isLoggedIn()) {
            this.activatedRoute.params.subscribe(params => {
                console.log(params);
                const id: number = +(params['id']);
                this.questionService.getAttemptById(id).subscribe(
                    (attempt) => {
                        console.log(attempt);
                        this.attempt = attempt;
                        /**
                         * attach explanation right after quesstion
                         *
                         * discolor right and wrong answers
                         */

                            // build question selected-answer map
                        const dict = {};
                        for (const selectedOpt of attempt.answers) {
                            for (const question of attempt.challenge.quiz.questions) {
                                for (const qOpt of question.options) {
                                    if (selectedOpt.id === qOpt.id) {
                                        if (!dict[question.id]) {
                                            dict[question.id] = [];
                                        }
                                        dict[question.id].push(selectedOpt);
                                    }
                                }
                            }
                        }
                        console.log(dict);

                        // for each question mark the ones seelcted as checked
                        for (const question of attempt.challenge.quiz.questions) {
                            const selected = dict[question.id];
                            if (selected) {
                                for (const qOpt of question.options) {
                                    for (const picked of selected) {
                                        if (picked.id === qOpt.id) {
                                            qOpt['wasPicked'] = true;
                                        }
                                    }
                                }
                            }
                        }
                    },
                    console.log
                );
            });
        }
        else {
            this.rout.navigate(["401"]);
        }
    }

    getOptionColor(opt: QuestionOption) {
        const incorrectColor = 'rgb(214, 174, 174)';
        const correctColor = 'rgb(174, 214, 174)';
        return opt.isCorrect? correctColor: incorrectColor;
    }
}
