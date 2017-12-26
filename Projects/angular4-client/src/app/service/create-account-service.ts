import {Observable} from "rxjs/Observable";
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Injectable} from "@angular/core";
import { FormGroup } from "@angular/forms/src/model";

@Injectable()
export class CreateAccountService{
    constructor(private http: HttpClient) {
    }

    public createAccount(userCred: string[]){
        let params = new FormData();
        params.append('fname', userCred[0]);
        params.append('mname', userCred[1]);
        params.append('lname', userCred[2]);
        params.append('username', userCred[3]);
        params.append('password', userCred[4]);
        params.append('email', userCred[5]);
        console.log("Test2:" + userCred);
        let options = {
            headers: new HttpHeaders(),
        };

        return this.http.post('http://localhost:8085/RevLearners/CreateAccount', params, options);
    }
}
