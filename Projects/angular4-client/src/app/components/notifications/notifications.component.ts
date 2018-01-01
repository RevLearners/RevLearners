import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';

import {User} from '../../model/user';
import {Notification} from '../../model/notification';

import {LoginCredentialsService} from '../../services/login-credentials.service';
import {AuthenticationService} from '../../services/authentication.service';
import {SessionToken} from '../../model/session-token';
import {HttpHeaders} from '@angular/common/http';

import {AUTHORIZATION_HEADER, TOKEN_HEADER} from '../../model/session-token';


@Component({
  selector: 'app-notifications',
  templateUrl: './notifications.component.html',
  styleUrls: ['./notifications.component.css']
})

export class NotificationsComponent implements OnInit {

  note: Notification;
  user: User;
  token: SessionToken = null;
  
  private headers = new HttpHeaders({'Content-Type': 'application/json'});
  
  constructor(private http:HttpClient, private validate:LoginCredentialsService) { }

  ngOnInit() {
    this.user = this.validate.getUser();
    this.token = this.validate.getToken();   
    // this.headers = this.headers.append(AUTHORIZATION_HEADER, this.user.username);
    // this.headers = this.headers.append(TOKEN_HEADER, this.token);
  }
  
  fetchUserNotes(): Observable<Notification> {
      let url = `http://localhost:4200/api/rest/notifications/getByUserId/${this.user.id}/`;
      return this.http.get(url, {headers: this.headers})
        .map((res: Response) => {
          return res.json().results.map(item => {
            return new Notification(
              item.id,
              item.senderId,
              item.receivers,
              item.title,
              item.contents,
              item.time,
              item.status
              );
            });
          });
  }
}
