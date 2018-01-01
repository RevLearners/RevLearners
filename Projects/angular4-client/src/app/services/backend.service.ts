import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Injectable, OnInit} from '@angular/core';
import {Observable} from 'rxjs/Observable';

import {Rank} from '../model/rank';
import {User} from '../model/user';
import {LoginCredentialsService} from './login-credentials.service';
import {AuthenticationService} from './authentication.service';
import {SessionToken} from '../model/session-token';

import {AUTHORIZATION_HEADER, TOKEN_HEADER} from '../model/session-token';
import { Router } from '@angular/router';

export const backendUrl = 'http://localhost:8085/RevLearners';

@Injectable()
export class BackendService implements OnInit{
    public rankId;
    public rank: Rank = new Rank(0, 0, "", 0, null);
    ranks: Rank[];
    user: User;
    token: SessionToken = null;

    private headers = new HttpHeaders({'Content-Type': 'application/json'});

    constructor(private http: HttpClient, private validate: LoginCredentialsService,
    private rout: Router) {
        this.user = this.validate.getUser();
        this.token = this.validate.getToken();
        if(this.token != null){
        this.headers = this.headers.append(AUTHORIZATION_HEADER, this.token.username);
        this.headers = this.headers.append(TOKEN_HEADER, this.token.token);
        console.log("Princewill's statement.");
        console.log(this.token);
        }
    }

    ngOnInit() {
        this.token = this.validate.getToken();
        if(this.token == null){
            this.rout.navigate(['401']);
        }
    }

    public getUsers() {
        console.log(this.token);
        return this.http.get('http://localhost:8085/api/rest/users/getList', {headers: this.headers});
    }

    public getTopics(): Observable<any[]> {
        console.log(this.token);
        return this.http.get<any[]>('http://localhost:8085/api/rest/topics/getList', {headers: this.headers});
    }
  
    public getMessages() {
        console.log(this.token);
        return this.http.get('http://localhost:8085/api/rest/messages/getList', {headers: this.headers});
    }
  
    public getNotifications() {
        return this.http.get('http://localhost:8085/api/rest/notifications/getList', {headers: this.headers});
    }

    public makeChallenge(challengeInfo: string[]){

        const challengeInfo2 = {
            "topicId": challengeInfo[0],
            "senderId": 1,
            "receiverIds": [challengeInfo[1]],
            "numQuestions": 5
        }

        const options = {
            headers: new HttpHeaders(),
        };

        return this.http.post('http://localhost:8085/api/rest/challenges/createChallenge', challengeInfo2, options)
    }
  
  
}
