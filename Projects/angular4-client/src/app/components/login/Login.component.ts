import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";

 
import { AuthenticationService } from '../../services/authentication.service';
 
@Component({
    moduleId: module.id,
    selector: 'app-login',
    templateUrl: './Login.component.html',
    styleUrls: ['./Login.component.css'],
    encapsulation: ViewEncapsulation.None,
})
 
export class LoginComponent implements OnInit {
    model: any = {username: "", password: ""};
    loading = false;
    userFound = false;
    error = '';
 
    constructor(
        private router: Router,
        private authenticationService: AuthenticationService) { }
 
    ngOnInit() {
        // reset login status
        this.authenticationService.logout();
    }
 
    login() {
        this.loading = true;
        this.authenticationService.login(this.model.username, this.model.password)
            .subscribe(result => {
                if (result === true) {
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