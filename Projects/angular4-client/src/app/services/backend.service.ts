import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Injectable, OnInit} from '@angular/core';

import {Rank} from '../model/rank';
import {User} from '../model/user';
import {LoginCredentialsService} from './login-credentials.service';
import {AuthenticationService} from './authentication.service';
import {SessionToken} from '../model/session-token';

import {AUTHORIZATION_HEADER, TOKEN_HEADER} from '../model/session-token';

export const backendUrl = 'http://localhost:8085/RevLearners';

@Injectable()
export class BackendService implements OnInit{
    public rankId;
    public rank: Rank = new Rank(0, 0, "", 0, null);
    ranks: Rank[];
    user: User;
    token: SessionToken = null;

    private headers = new HttpHeaders({'Content-Type': 'application/json'});

    constructor(private http: HttpClient, private validate: LoginCredentialsService) {
        this.user = this.validate.getUser();
        this.token = this.validate.getToken();
        this.headers = this.headers.append(AUTHORIZATION_HEADER, this.token.username);
        this.headers = this.headers.append(TOKEN_HEADER, this.token.token);
        console.log("Princewill's statement.");
        console.log(this.token);
    }

    ngOnInit() {

    }

    public getUsers() {
        console.log(this.token);
        return this.http.get('http://localhost:8085/api/rest/users/getList', {headers: this.headers});
    }
}
