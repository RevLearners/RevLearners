import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Injectable, OnInit} from '@angular/core';

import {Rank} from '../model/rank';
import {User} from '../model/user';
import {LoginCredentialsService} from './login-credentials.service';
import {SessionToken} from '../model/session-token';

import { AUTHORIZATION_HEADER, TOKEN_HEADER } from '../model/session-token';
import { Router } from '@angular/router';
import {Observable} from "rxjs/Observable";

@Injectable()
export class BackendService implements OnInit {
    ranks: Rank[];
    user: User;
    token: SessionToken = null;
    headers: HttpHeaders;

    constructor(private http: HttpClient, private creds: LoginCredentialsService,
        private rout: Router) {
        this.user = this.creds.getUser();
        this.token = this.creds.getToken();
    }

    ngOnInit() {
        if (!this.creds.isLoggedIn()) {
            this.rout.navigate(['401']);
        }
        else {
            this.headers = this.creds.prepareAuthHeaders();
        }
    }

    public getCerts() {
        return this.http.get('http://localhost:8085/api/rest/certifications/getList', { headers: this.headers });
    }

    public getUsers() {
        console.log(this.token);
        return this.http.get('http://localhost:8085/api/rest/users/getList', { headers: this.headers });
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

}
