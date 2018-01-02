import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from '../../model/user';
import { Role } from '../../model/role';
import { LoginCredentialsService } from '../../services/login-credentials.service';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/takeWhile';

import { SessionToken } from '../../model/session-token';
import { HttpHeaders } from '@angular/common/http';

import { Message } from '../../model/message';

import { BackendService } from '../../services/backend.service';

import { AUTHORIZATION_HEADER, TOKEN_HEADER } from '../../model/session-token';
import { MonitorService } from '../../services/monitor.service';

import { IntervalObservable } from "rxjs/observable/IntervalObservable";

export const MSG_CACHE = "userMessages";
export const NOTIF_CACHE = "userNotifications";

@Component({
    selector: 'app-nav-bar',
    templateUrl: './navbar.component.html',
    styleUrls: [
        './navbar.component.css'
    ]
})
export class NavbarComponent implements OnInit {

    msgs: IntervalObservable;
    notifs: IntervalObservable;

    messageCount: number;
    notificationCount: number;

    msgArr: Message[] = [];
    notArr: Notification[] = [];

    private msgAlive: boolean;
    private notifAlive: boolean;

    unread = 'rgb(198, 86, 37)';
    read = 'rgba(0, 0, 0, 0.2)';

    msgNew: boolean = false;
    notNew: boolean = false;

    user: User;
    role: Role = { id: 0, name: "" };

    token: SessionToken = null;

    private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

    constructor(private http: HttpClient, private validate: LoginCredentialsService,
        private bs: BackendService) { }

    ngOnInit() {
        this.token = this.validate.getToken();
        this.appendHeaders();
        //this.role.name = localStorage.getItem(role);
    }

    public invokeMessageMonitor() {
        this.msgAlive = true;
        if (this.token != null) {
            IntervalObservable.create(10000
            ).takeWhile(() => this.msgAlive) // only fires when component is alive
                .subscribe(() => {
                    this.bs.getMessages().subscribe((data: any) => {
                        if (this.messageCount < this.msgArr.length) {
                            this.msgNew = true;
                            console.log("Msg", data);
                            localStorage.setItem(MSG_CACHE, JSON.stringify(data));
                            this.msgArr = data;
                            this.messageCount = this.msgArr.length;
                        }
                    });
                }
                )
        }
        else {
            this.stopMessageMonitor();
        }
    }

    public stopMessageMonitor() {
        this.msgAlive = false;
    }

    public stopMonitors() {
        this.stopMessageMonitor();
        this.stopNotificationMonitor();
    }

    public invokeNotificationMonitor() {
        this.msgAlive = true;
        if (this.token != null) {
            IntervalObservable.create(10000
            ).takeWhile(() => this.msgAlive) // only fires when component is alive
                .subscribe(() => {
                    this.bs.getNotifications().subscribe((data: any) => {
                        if (this.notificationCount < this.msgArr.length) {
                            this.notNew = true;
                            console.log("Notifs", data);
                            localStorage.setItem(NOTIF_CACHE, JSON.stringify(data));
                            this.notArr = data;
                            this.notificationCount = this.msgArr.length;
                        }
                    });
                }
                )
        }
        else {
            this.stopNotificationMonitor();
        }
    }

    public stopNotificationMonitor() {
        this.notifAlive = false;
    }

    public appendHeaders() {
        this.user = this.validate.getUser();
        this.token = this.validate.getToken();
        if (this.token != null) {
            this.headers = this.headers.append(AUTHORIZATION_HEADER, this.token.username);
            this.headers = this.headers.append(TOKEN_HEADER, this.token.token);
            this.invokeMessageMonitor();
            this.invokeNotificationMonitor();
        }
    }

    public invokeMonitors() {
        this.invokeMessageMonitor();
        this.invokeNotificationMonitor();
    }

    public fetchRole(user: User) {
        let url = `http://localhost:4200/api/rest/roles/getById/${user.id}/`;
        this.http.get(url, { headers: this.headers }).subscribe(
            data => {
                this.role.id = data["id"],
                    this.role.name = data["name"]
            },
            err => {
                this.role.id = -1,
                    this.role.name = "error"
            }
        )
    }

}



