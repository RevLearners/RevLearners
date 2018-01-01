import { Component, OnInit } from '@angular/core';

import {SessionToken } from '../../model/session-token';
import { LoginCredentialsService } from '../../services/login-credentials.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-verify-email',
  templateUrl: './verify-email.component.html',
  styleUrls: ['./verify-email.component.css']
})
export class VerifyEmailComponent implements OnInit {

  token: SessionToken;

  constructor(private lcs: LoginCredentialsService, private rout: Router) { }

  ngOnInit() {
      this.token = this.lcs.getToken();
      if(this.token == null){
        this.rout.navigate(['401']);
      }
  }

}
