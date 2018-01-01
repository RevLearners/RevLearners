import { Component, OnInit } from '@angular/core';
import { SessionToken } from '../../model/session-token';
import { LoginCredentialsService } from '../../services/login-credentials.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-approve-certifications',
  templateUrl: './approve-certifications.component.html',
  styleUrls: ['./approve-certifications.component.css']
})
export class ApproveCertificationsComponent implements OnInit {

  token: SessionToken;

  constructor(private lcs: LoginCredentialsService, private rout: Router) { }

  ngOnInit() {
    this.token = this.lcs.getToken();
    if(this.token != null){}
    else{
      this.rout.navigate(["401"]);
    }
  }

}
