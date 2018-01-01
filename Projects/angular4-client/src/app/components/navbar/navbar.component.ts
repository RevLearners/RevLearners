import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from '../../model/user';
import { Role } from '../../model/role';
import { LoginCredentialsService } from '../../services/login-credentials.service';
import { Observable } from 'rxjs/Rx';

import { SessionToken } from '../../model/session-token';
import { HttpHeaders } from '@angular/common/http';

import { AUTHORIZATION_HEADER, TOKEN_HEADER } from '../../model/session-token';


@Component({
    selector: 'app-nav-bar',
    templateUrl: './navbar.component.html',
    styleUrls: [
        './navbar.component.css'
    ]
})
export class NavbarComponent implements OnInit {
    
    user: User;
    role: Role;

    token: SessionToken = null;

    private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

    notificationCount: number;
    messageCount: number;

    constructor(private http: HttpClient, private validate: LoginCredentialsService) { }

    ngOnInit() {
        this.token = this.validate.getToken();
    }

    public appendHeaders() {
        this.user = this.validate.getUser();
        this.token = this.validate.getToken();
        if (this.token != null) {
            this.headers = this.headers.append(AUTHORIZATION_HEADER, this.token.username);
            this.headers = this.headers.append(TOKEN_HEADER, this.token.token);
            this.invokeMonitors();
        }
    }

    public invokeMonitors() {}

    public fetchRole(user: User) {
        let url = `http://localhost:4200/api/rest/roles/getById/${user.id}/`;
        this.http.get(url, {headers: this.headers}).subscribe(
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



