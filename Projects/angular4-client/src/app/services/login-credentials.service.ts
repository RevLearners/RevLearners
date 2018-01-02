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

    setToken(token: SessionToken): void {
        localStorage.setItem(SESSION_KEY, JSON.stringify(token));
    }

    getToken(): SessionToken {
        return JSON.parse(localStorage.getItem(SESSION_KEY));
    }

    setUser(user: any): void {
        localStorage.setItem(SESSION_USER, JSON.stringify(user));
    }

    getUser(): any {
        return JSON.parse(localStorage.getItem(SESSION_USER));
    }

    clear(): void {
        localStorage.clear();
    }

    prepareAuthHeaders(): HttpHeaders {
        const token: SessionToken = this.getToken();
        let headers = new HttpHeaders({'Content-Type': 'application/json'});
        headers = headers.append(AUTHORIZATION_HEADER, token.username);
        headers = headers.append(TOKEN_HEADER, token.token);
        return headers;
    }

    isLoggedIn(): boolean {
        return this.getToken() != null;
    }

    navigateToLogin(router: Router) {
        router.navigate(['/login']);
    }

}
