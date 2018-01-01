import {Injectable} from '@angular/core';
import 'rxjs/add/observable/of';
import 'rxjs/add/observable/empty';
import 'rxjs/add/operator/map';

import {SessionToken} from '../model/session-token';

export const SESSION_KEY = "currentUser";

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
      this.user = user;
  }

  getUser(): any {
    return this.user;
  }

  clear(): void {
      this.user = null;
      this.token = null;
  }

  isLoggedIn(): boolean {
    return this.token != null;
  }
}
