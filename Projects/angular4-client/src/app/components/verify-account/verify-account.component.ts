import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AuthenticationService } from '../../services/authentication.service';
import { Router } from '@angular/router';

@Component({
    selector: 'app-verify-account',
    templateUrl: './verify-account.component.html',
    styleUrls: ['./verify-account.component.css']
})
export class VerifyAccountComponent implements OnInit {

    constructor(private activeRoute: ActivatedRoute, private authService: AuthenticationService,
    private rout: Router) {
    }

    ngOnInit() {
        this.activeRoute.queryParams.subscribe(
            (params) => {
                if (params["token"] != null) {
                    this.authService.verifyAccount(params["token"]).subscribe(
                        (wasVerified) => {
                            console.log("wasVerified", wasVerified);
                        }
                    );
                }
                else{
                    this.rout.navigate(['401']);
                }
            }
        );
    }
}
