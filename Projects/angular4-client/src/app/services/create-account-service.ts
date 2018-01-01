import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';

@Injectable()
export class CreateAccountService {
    constructor(private http: HttpClient) {
    }

    public createAccount(userCred: string[]){

        const userInfo = {
            firstName: userCred[0],
            middleName: userCred[1],
            lastName: userCred[2],
            username: userCred[3],
            password: userCred[4],
            email: userCred[5]
        };

        console.log("Test2:" + userCred);
        const options = {
            headers: new HttpHeaders(
                {
                    'Content-Type' : 'application/json'
                }
            ),
        };

        return this.http.post('http://localhost:8085/register', userInfo, options);     // watch the f****** trailing slashes
    }

    public userExist(username: string) {

        const data = new FormData();
        data.append('username', username);

        const options = {
            headers: new HttpHeaders(),
        };

        // Link will change after the rest calls/controller has been fully set up
        return this.http.get('http://localhost:8085/userExist/' + username, options);        // watch the f****** trailing slashes
    }
}
