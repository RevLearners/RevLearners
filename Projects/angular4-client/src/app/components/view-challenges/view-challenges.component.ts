import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import 'rxjs/add/operator/map';

import { Quiz } from '../../model/quiz'
import { Question } from '../../model/question';
import { Topic } from '../../model/topic';
import { User } from '../../model/user';
import { Challenge } from '../../model/challenge';
import { ChallengeAttempt } from '../../model/challenge-attempt';

import { LoginCredentialsService } from '../../services/login-credentials.service';
import { AuthenticationService } from '../../services/authentication.service';
import { SessionToken } from '../../model/session-token';
import { HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs/Observable';

import { AUTHORIZATION_HEADER, TOKEN_HEADER } from '../../model/session-token';

import { QuestionService } from "../../services/question.service";

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

  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient, private validate: LoginCredentialsService,
    private rout: Router, private challengeService: QuestionService) { }

  ngOnInit() {
    this.user = this.validate.getUser();
    this.token = this.validate.getToken();
    if (this.user != null && this.token != null) {
      this.headers = this.headers.append(AUTHORIZATION_HEADER, this.token.username);
      this.headers = this.headers.append(TOKEN_HEADER, this.token.token);
      this.challengeService.getChallengesForUser().subscribe(
        (data: Challenge[]) => {
          console.log("========== Challenges ============", data);
          this.challenges = data;
        },
        console.log
      );
    }
    else {
      this.rout.navigate(["401"]);
    }
  }
}
