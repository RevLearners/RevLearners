import {Observable} from 'rxjs/Observable';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {FormGroup} from '@angular/forms/src/model';

@Injectable()
export class CreateAccountService {
    constructor(private http: HttpClient) {
    }

    public createAccount(userCred: string[]){
        let data = new FormData();
        data.append('fname', userCred[0]);
        data.append('mname', userCred[1]);
        data.append('lname', userCred[2]);
        data.append('username', userCred[3]);
        data.append('password', userCred[4]);
        data.append('email', userCred[5]);
        console.log("Test2:" + userCred);
        let options = {
            headers: new HttpHeaders(),
        };

        return this.http.post('http://localhost:8085/RevLearners/CreateAccount', data, options);
    }

    public userExist(username: string) {

        const data = new FormData();
        data.append('username', username);

        const options = {
            headers: new HttpHeaders(),
        };

        // Link will change after the rest calls/controller has been fully set up
        return this.http.post('http://localhost:8085/RevLearners/???', data, options);
    }
}
