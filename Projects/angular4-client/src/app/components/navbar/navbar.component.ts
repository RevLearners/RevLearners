import {HttpClient} from '@angular/common/http';
import {Component} from '@angular/core';
import {User} from '../../model/user';
import {Role} from '../../model/role';
import {LoginCredentialsService} from '../../services/login-credentials.service';
import {Observable} from 'rxjs/Rx';

import {SessionToken} from '../../model/session-token';
import {HttpHeaders} from '@angular/common/http';

import {AUTHORIZATION_HEADER, TOKEN_HEADER} from '../../model/session-token';


@Component ({
    selector: 'app-nav-bar',
    templateUrl: './navbar.component.html',
    styleUrls:[
        './navbar.component.css'
    ]
})
export class NavbarComponent{
  
  user: User;
  role: Role;
  
  token: SessionToken = null;

  private headers = new HttpHeaders({'Content-Type': 'application/json'});

  notificationCount: number;
  messageCount: number;
  
constructor(private http: HttpClient, private validate:LoginCredentialsService) { }

  ngOnInit() {
    }

    public appendHeaders() {
        this.user = this.validate.getUser();
        this.token = this.validate.getToken();
        this.headers = this.headers.append(AUTHORIZATION_HEADER, this.token.username);
        this.headers = this.headers.append(TOKEN_HEADER, this.token.token);
        this.invokeMonitors();
    }

    public invokeMonitors() {
    // notificationCount = fetchNoteCount().
    }
    
    
//    fetchNoteCount() {
//      let url = `http://localhost:4200/api/rest/notifications/getByUserId/${this.user.id}/`;
}


//    fetchNoteCount() {
//      let url = `http://localhost:4200/api/rest/notifications/getByUserId/${this.user.id}/`;
//      this.http.get(url, {headers: this.headers}).subscribe(
//        (data: Notification[]) => {
//          console.log(data);
//        },
//        err => {
//          
//        }
//      )
//    }



//  Observable.interval(200 * 60).subscribe(
//    x => {
//    doSomething();
//    }
//  );

/**
 * appendHeaders
 */
