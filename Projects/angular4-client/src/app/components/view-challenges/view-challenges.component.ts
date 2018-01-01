import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';

import {Quiz} from '../../model/quiz'
import {Question} from '../../model/question';
import {Topic} from '../../model/topic';
import {User} from '../../model/user';
import {Challenge} from '../../model/challenge';
import {ChallengeAttempt} from '../../model/challenge-attempt';

import {LoginCredentialsService} from '../../services/login-credentials.service';
import {AuthenticationService} from '../../services/authentication.service';
import {SessionToken} from '../../model/session-token';
import {HttpHeaders} from '@angular/common/http';

import {AUTHORIZATION_HEADER, TOKEN_HEADER} from '../../model/session-token';

@Component({
  selector: 'app-view-challenges',
  templateUrl: './view-challenges.component.html',
  styleUrls: ['./view-challenges.component.css']
})
export class ViewChallengesComponent implements OnInit {
  
  chall: Challenge;
  quiz: Quiz;  
  user: User;
  token: SessionToken = null;
  
  private headers = new HttpHeaders({'Content-Type': 'application/json'});
  
  constructor(private http:HttpClient, private validate:LoginCredentialsService) { }

  ngOnInit() {
    this.user = this.validate.getUser();
    this.token = this.validate.getToken();
    this.headers = this.headers.append(AUTHORIZATION_HEADER, this.token.username);
    this.headers = this.headers.append(TOKEN_HEADER, this.token.token);
  }
  
  fetchUserQuiz(): Observable<Challenge>{
    let url = `http://localhost:4200/api/challenges/getChallengesByUser/${this.user.id}/`;
    return this.http.get(url, {headers: this.headers})
      .map((res:Response) => {
        return res.json().results.map(item => {
          return new Challenge(
            item.id,
            item.quiz,
            item.users,
            item.attempts
            );
          });
        });
  }
       
  
}
