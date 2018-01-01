import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';

import 'rxjs/add/operator/map';

import {Quiz} from '../../model/quiz'
import {User} from '../../model/user';
import {Challenge} from '../../model/challenge';

import {LoginCredentialsService} from '../../services/login-credentials.service';
import {SessionToken} from '../../model/session-token';

import {QuestionService} from "../../services/question.service";

@Component({
    selector: 'app-view-challenges',
    templateUrl: './view-challenges.component.html',
    styleUrls: ['./view-challenges.component.css']
})
export class ViewChallengesComponent implements OnInit {

    challenges: Challenge[];
    quiz: Quiz;
    user: User;
    token: SessionToken = null;

    constructor(private http: HttpClient, private validate: LoginCredentialsService,
                private challengeService: QuestionService) {
    }

    ngOnInit() {
        this.challengeService.getChallengesForUser().subscribe(
            (data: Challenge[]) => {
                console.log("========== Challenges ============", data);
                this.challenges = data;
            },
            console.log
        );
    }


}
