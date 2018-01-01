import {User} from '../model/user';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import 'rxjs/add/observable/empty';
import 'rxjs/add/operator/map';

import {SessionToken} from '../model/session-token';
import {USER1} from './question.service';

export const SESSION_KEY = "currentUser";

@Injectable()
export class LoginCredentialsService {
  user: User = null;
  token: SessionToken = null;

  login(username: string, password: string): Observable<User> {
    return Observable.of(USER1)
      .map((res: User) => this.user = res);
  }

  logout(): Observable<any> {
    this.user = null;
    return Observable.empty();
  }

  setToken(token: SessionToken): void {
    this.token = JSON.parse(localStorage.getItem(SESSION_KEY));
  }

  getToken(): SessionToken {
    return JSON.parse(localStorage.getItem(SESSION_KEY));
  }

  getUser(): User {
    return this.user;
  }

  isLoggedIn(): boolean {
    return this.token != null;
  }
}
