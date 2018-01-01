import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';

import {User} from '../../model/user';
import {Certification} from '../../model/certification';

import {LoginCredentialsService} from '../../services/login-credentials.service';
import {AuthenticationService} from '../../services/authentication.service';
import {SessionToken} from '../../model/session-token';
import {HttpHeaders} from '@angular/common/http';

import {AUTHORIZATION_HEADER, TOKEN_HEADER} from '../../model/session-token';


@Component({
  selector: 'app-approve-certifications',
  templateUrl: './approve-certifications.component.html',
  styleUrls: ['./approve-certifications.component.css']
})
export class ApproveCertificationsComponent implements OnInit {

  cert: Certification;
  user: User;
  token: SessionToken = null;
  
  private headers = new HttpHeaders({'Content-Type': 'application/json'});
  
  constructor(private http:HttpClient, private validate:LoginCredentialsService) { }

  ngOnInit() {
    this.user = this.validate.getUser();
    this.token = this.validate.getToken();
    this.headers = this.headers.append(AUTHORIZATION_HEADER, this.token.username);
    this.headers = this.headers.append(TOKEN_HEADER, this.token.token);
  }

  fetchAllCert(): Observable<Certification> {
    let url = `http://localhost:4200/api/rest/certification/getList/`;
    return this.http.get(url, {headers: this.headers})
     .map((res: Response) => {
       return res.json().results.map(item => {
         return new Certification(
           item.id,
           item.name,
           item.topic,
           item.user,
           item.status
           );
         });
       });
  }
  
}

