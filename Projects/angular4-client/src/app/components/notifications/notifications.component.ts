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


    constructor(private http: HttpClient, private router: Router, private creds: LoginCredentialsService, private dataservice: BackendService) {
    }

    ngOnInit() {
        this.user = this.creds.getUser();
        this.token = this.creds.getToken();

        if (this.creds.isLoggedIn()) {
            this.dataservice.getNotifications().subscribe(
                (data: any) => {
                    this.notes = data;
                    console.log("Notification Data");
                    console.log(data);
                },
                console.log
            )
        } else {
            this.creds.navigateToLogin(this.router);
        }
    }

}


