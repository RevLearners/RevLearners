import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { QuestionService } from '../../services/question.service';
import { Quiz } from '../../model/quiz';
import { User } from '../../model/user';
import { SessionToken } from '../../model/session-token';
import { LoginCredentialsService } from '../../services/login-credentials.service';
import { Router } from '@angular/router';

@Component({
    selector: 'app-review-quiz',
    templateUrl: './review-challenge.component.html',
    styleUrls: ['./review-challenge.component.css']
})
export class ReviewChallengeComponent implements OnInit {

    user: User;
    token: SessionToken;
    quiz: Quiz;

    constructor(private questionService: QuestionService, private activatedRoute: ActivatedRoute,
        private lcs: LoginCredentialsService, private rout: Router) {
    }

    ngOnInit() {
        this.token = this.lcs.getToken();
        if (this.token != null) {
            this.activatedRoute.params.subscribe(params => {
                console.log(params);
                const id: number = +(params['id']);
                this.questionService.getQuizById(id).subscribe(
                    (quiz: Quiz) => this.quiz = quiz,
                    console.log
                );
            });
        }
        else{
          this.rout.navigate(["401"]);
        }
    }
}
