import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';

import { User } from '../../model/user';
import { Message } from '../../model/message';

import { LoginCredentialsService } from '../../services/login-credentials.service';
import { AuthenticationService } from '../../services/authentication.service';
import { SessionToken } from '../../model/session-token';
import { HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

import { AUTHORIZATION_HEADER, TOKEN_HEADER } from '../../model/session-token';


@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {

  msg: Message;
  user: User;
  token: SessionToken = null;

  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient, private validate: LoginCredentialsService,
  private rout: Router ) { }

  ngOnInit() {
    this.user = this.validate.getUser();
    this.token = this.validate.getToken();
    if (this.user != null && this.token != null) {
      this.headers = this.headers.append(AUTHORIZATION_HEADER, this.token.username);
      this.headers = this.headers.append(TOKEN_HEADER, this.token.token);
    }
  }

  fetchUserMsgs(): Observable<Notification> {
    if (this.token != null) {
      let url = `http://localhost:4200/api/rest/messages/getByUserId/${this.user.id}/`;
      return this.http.get(url, { headers: this.headers })
        .map((res: Response) => {
          return res.json().results.map(item => {
            return new Message(
              item.id,
              item.contents,
              item.time,
              item.senderId,
              item.receivers,
              item.attachment,
              item.title,
              item.status
            );
          });
        });
    }
    else{
      this.rout.navigate(["401"]);
    }
  }

}
