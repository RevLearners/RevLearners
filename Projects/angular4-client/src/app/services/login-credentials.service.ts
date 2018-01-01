import {Injectable} from '@angular/core';
import 'rxjs/add/observable/of';
import 'rxjs/add/observable/empty';
import 'rxjs/add/operator/map';

import {AUTHORIZATION_HEADER, SessionToken, TOKEN_HEADER} from '../model/session-token';
import {HttpHeaders} from "@angular/common/http";
import {Router} from "@angular/router";


export const SESSION_KEY = "token";
export const SESSION_USER = "currentUser";

@Injectable()
export class LoginCredentialsService {

    user: any = null;

    token: SessionToken = null;

    setToken(token: SessionToken): void {
        localStorage.setItem(SESSION_KEY, JSON.stringify(token));
        this.token = token;
    }

    getToken(): SessionToken {
        return JSON.parse(localStorage.getItem(SESSION_KEY));
    }

    setUser(user: any): void {
        localStorage.setItem(SESSION_USER, JSON.stringify(user));
        this.user = user;
    }

    getUser(): any {
        return JSON.parse(localStorage.getItem(SESSION_USER));
    }

    clear(): void {
        this.user = null;
        this.token = null;
    }

    prepareAuthHeaders(): HttpHeaders {
        let headers = new HttpHeaders({'Content-Type': 'application/json'});
        headers = headers.append(AUTHORIZATION_HEADER, this.token.username);
        headers = headers.append(TOKEN_HEADER, this.token.token);
        return headers;
    }

    isLoggedIn(): boolean {
        return this.token != null;
    }

    navigateToLogin(router: Router) {
        router.navigate(['/login']);
    }

}
