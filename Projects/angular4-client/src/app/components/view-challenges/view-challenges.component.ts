import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';

import 'rxjs/add/operator/map';

import {Quiz} from '../../model/quiz'
import {User} from '../../model/user';
import {Challenge} from '../../model/challenge';

import {LoginCredentialsService} from '../../services/login-credentials.service';
import {SessionToken} from '../../model/session-token';

import {QuestionService} from "../../services/question.service";
import {Router} from "@angular/router";



@Component({
    selector: 'app-view-challenges',
    templateUrl: './view-challenges.component.html',
    styleUrls: ['./view-challenges.component.css']
})
export class ViewChallengesComponent implements OnInit {
    CHALLENGE_BASE_URL = "complete-challenge";

    challenges: Challenge[];
    quiz: Quiz;
    user: User;
    token: SessionToken = null;

    constructor(private http: HttpClient, private creds: LoginCredentialsService,
                private challengeService: QuestionService, private router: Router) {
    }

    ngOnInit() {
        if (this.creds.isLoggedIn()) {  // redirect users not logged in
            this.challengeService.getChallengesForUser().subscribe(
                (data: Challenge[]) => {
                    console.log("========== Challenges ============", data);
                    this.challenges = data;
                },
                console.log
            );
        }
        else {
            this.creds.navigateToLogin(this.router);
        }

    }


}
