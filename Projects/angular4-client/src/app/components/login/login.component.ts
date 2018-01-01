import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Router } from '@angular/router';


import { AuthenticationService } from '../../services/authentication.service';
import {Ng4LoadingSpinnerService } from 'ng4-loading-spinner';

@Component({
    moduleId: module.id,
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css'],
})

export class LoginComponent implements OnInit {
    model: any = {username: "", password: ""};
    loading = false;
    userFound = false;
    error = '';

    constructor(
        private router: Router,
        private authenticationService: AuthenticationService,
        private spinner: Ng4LoadingSpinnerService) { }

    ngOnInit() {
        this.authenticationService.logout();
    }

    login() {
        this.loading = true;
        this.spinner.show();
        this.authenticationService.login(this.model.username, this.model.password)
            .subscribe(result => {
                this.spinner.hide();
                console.log("login info", result);
                if (result == true) {
                    // login successful
                    this.router.navigate(['profile']);
                } else {
                    // login failed
                    this.error = 'Username or password is incorrect';
                    this.loading = false;
                }
            }, error => {
                this.loading = false;
                this.error = error;
                console.log(error);
            });
    }
}
