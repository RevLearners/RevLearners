import {Observable} from 'rxjs/Observable';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {FormGroup} from '@angular/forms/src/model';

@Injectable()
export class CreateAccountService {
    constructor(private http: HttpClient) {
    }

    public createAccount(userCred: string[]){

        let userInfo = {
            firstName: userCred[0],
            middleName: userCred[1],
            lastName: userCred[2],
            username: userCred[3],
            password: userCred[4],
            email: userCred[5]
        }

        console.log("Test2:" + userCred);
        let options = {
            headers: new HttpHeaders(
                {
                    'Content-Type' : 'application/json'

                }
            ),
        };

        return this.http.post('http://localhost:8085/register', userInfo, options);
    }

    public userExist(username: string) {

        const data = new FormData();
        data.append('username', username);

        const options = {
            headers: new HttpHeaders(),
        };

        // Link will change after the rest calls/controller has been fully set up
        return this.http.get('/api/rest/users/userExist/' + username + '/');
    }
}
