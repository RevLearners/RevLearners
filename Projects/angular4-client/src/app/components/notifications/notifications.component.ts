import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import 'rxjs/add/operator/map';

import {User} from '../../model/user';
import {Notification} from '../../model/notification';

import {LoginCredentialsService} from '../../services/login-credentials.service';
import {AUTHORIZATION_HEADER, SessionToken, TOKEN_HEADER} from '../../model/session-token';
import {HttpHeaders} from '@angular/common/http';
import {Observable} from "rxjs/Observable";
import {Router} from "@angular/router";



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

  constructor(private http:HttpClient, private creds:LoginCredentialsService, private router: Router) { }

  ngOnInit() {
      if (!this.creds.isLoggedIn()) {
          console.log("===== is logged in ====", this.creds.isLoggedIn());
          this.router.navigate(['/login']);
      }
  }

  fetchUserNotes(): Observable<Notification> {
      const url = `http://localhost:4200/api/rest/notifications/getByUserId/${this.user.id}/`;
      return this.http.get(url, {headers: this.creds.prepareAuthHeaders()})
        .map((res: any) => {
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
