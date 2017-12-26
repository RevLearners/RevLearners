import {User} from '../model/user';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import 'rxjs/add/observable/empty';
import 'rxjs/add/operator/map';

import {USER1} from './question.service';


@Injectable()
export class LoginCredentialsService {
    user: User = null;

    login(username: string, password: string): Observable<User> {
        return Observable.of(USER1)
            .map((res: User) => this.user = res);
    }

    logout(): Observable<any> {
        this.user = null;
        return Observable.empty();
    }

    getUser(): User {
        return this.user;
    }

    isLoggedIn(): boolean {
        return this.user === null;
    }
}
