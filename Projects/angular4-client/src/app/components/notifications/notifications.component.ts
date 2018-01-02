import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import 'rxjs/add/operator/map';

import {User} from '../../model/user';
import {Notification} from '../../model/notification';

import {LoginCredentialsService} from '../../services/login-credentials.service';
import {SessionToken} from '../../model/session-token';

import {BackendService} from '../../services/backend.service';
import {Router} from "@angular/router";


@Component({
    selector: 'app-notifications',
    templateUrl: './notifications.component.html',
    styleUrls: ['./notifications.component.css']
})

export class NotificationsComponent implements OnInit {

  note: Notification;
  notes: Notification[];
  user: User;
  token: SessionToken = null;
  
  private headers = new HttpHeaders({'Content-Type': 'application/json'});
  
  constructor(private http:HttpClient, private validate:LoginCredentialsService, private dataservice:BackendService,
              private rout: Router) { }

  ngOnInit() {
    this.user = this.validate.getUser();
    this.token = this.validate.getToken();
    
    if (this.user != null && this.token != null) {
      this.headers = this.headers.append(AUTHORIZATION_HEADER, this.token.username);
      this.headers = this.headers.append(TOKEN_HEADER, this.token.token);
    }
    
    if (this.token != null) {
      this.dataservice.getNotifications().subscribe(
        (data: any) =>{
            this.notes = data;
            console.log("Notification Data");
            console.log(data);
        }
    } else{
      this.rout.navigate(["401"]);
    }
    )
  }
}

  
  
  

