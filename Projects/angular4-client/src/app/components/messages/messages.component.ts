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

import {BackendService} from '../../services/backend.service';

import { AUTHORIZATION_HEADER, TOKEN_HEADER } from '../../model/session-token';


@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {

  msg: Message;
  msgs: Message[];
  user: User;
  token: SessionToken = null;

  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient, private validate: LoginCredentialsService, private dataservice:BackendService,
  private rout: Router ) { }

  ngOnInit() {
    this.user = this.validate.getUser();
    this.token = this.validate.getToken();
    
    if (this.user != null && this.token != null) {
      this.headers = this.headers.append(AUTHORIZATION_HEADER, this.token.username);
      this.headers = this.headers.append(TOKEN_HEADER, this.token.token);
    }
    
    // the below method is returning all messages... 
    if (this.token != null) {
      this.dataservice.getMessages().subscribe(
        (data: any) =>{
            this.msgs = data;
            console.log("Message Data");
            console.log(data);
        }
        )
    } else{
      this.rout.navigate(["401"]);
    }
  }

 
}
