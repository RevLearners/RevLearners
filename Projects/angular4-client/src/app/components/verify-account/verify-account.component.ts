import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {AuthenticationService} from '../../services/authentication.service';

@Component({
    selector: 'app-verify-account',
    templateUrl: './verify-account.component.html',
    styleUrls: ['./verify-account.component.css']
})
export class VerifyAccountComponent implements OnInit {

    constructor(private activeRoute: ActivatedRoute, private authService: AuthenticationService) {
    }

    ngOnInit() {
        this.activeRoute.queryParams.subscribe(
            (params) => {
                this.authService.verifyAccount(params["token"]).subscribe(
                    (wasVerified) => {
                        console.log("wasVerified", wasVerified);
                    }
                );
            }
        );
    }


}
