import {SessionToken} from '../model/session-token';
import {LoginCredentialsService} from './login-credentials.service';
import {HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable()
export class AuthenticationService {
    private authUrl = 'http://localhost:8085/auth';
    private verifyUrl = 'http://localhost:8085/verify';
    private headers = new HttpHeaders({'Content-Type': 'application/json'});

    constructor(private http: HttpClient, private creds: LoginCredentialsService) {
    }

    verifyAccount(token: string): Observable<boolean> {
        return this.http.post<boolean>(this.verifyUrl, token);
    }

    login(username: string, password: string): Observable<boolean> {
        return this.http.post(this.authUrl, JSON.stringify({username: username, password: password}), {
            headers: this.headers,
            withCredentials: true
        })
            .map((response: Response) => {
                // login successful if there's a jwt token in the response
                const token = response && response['token'];
                console.log(response);
                if (token) {
                    // store username and jwt token in local storage to keep user logged in between page refreshes
                    localStorage.setItem('currentUser', JSON.stringify({username: username, token: token}));
                    this.creds.setToken(new SessionToken(username, token));
                    // return true to indicate successful login
                    return true;
                } else {
                    // return false to indicate failed login
                    return false;
                }
            }).catch((error: any) => Observable.throw(error));
    }

    getToken(): String {
        const currentUser = this.creds.getToken();
        const token = currentUser && currentUser.token;
        return token ? token : '';
    }

    logout(): void {
        // clear token remove user from local storage to log user out
        localStorage.removeItem('currentUser');
        this.creds.setToken(null);
    }
}
