import {Injectable} from '@angular/core';
import 'rxjs/add/observable/of';
import 'rxjs/add/observable/empty';
import 'rxjs/add/operator/map';

import {AUTHORIZATION_HEADER, SessionToken, TOKEN_HEADER} from '../model/session-token';
import {HttpHeaders} from "@angular/common/http";


export const SESSION_KEY = "token";
export const SESSION_USER = "currentUser";

@Injectable()
export class LoginCredentialsService {

    user: any = null;

    token: SessionToken = null;

    setToken(token: SessionToken): void {
        this.token = JSON.parse(localStorage.getItem(SESSION_KEY));
    }

    getToken(): SessionToken {
        return JSON.parse(localStorage.getItem(SESSION_KEY));
    }

    setUser(user: any): void {
        this.user = JSON.parse(localStorage.getItem(SESSION_USER));
    }

    getUser(): any {
        return this.user;
    }

    clear(): void {
        this.user = null;
        this.token = null;
    }

    public prepareAuthHeaders(): HttpHeaders {
        let headers = new HttpHeaders({'Content-Type': 'application/json'});
        headers = headers.append(AUTHORIZATION_HEADER, this.token.username);
        headers = headers.append(TOKEN_HEADER, this.token.token);
        return headers;
    }

    isLoggedIn(): boolean {
        return this.token != null;
    }
}
