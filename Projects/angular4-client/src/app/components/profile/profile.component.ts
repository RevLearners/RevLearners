import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

import { LoginCredentialsService } from '../../services/login-credentials.service';
import { AuthenticationService } from '../../services/authentication.service';

import { Rank } from '../../model/rank';
import { Role } from '../../model/role';
import { User } from '../../model/user';
import { SessionToken } from '../../model/session-token';
import { Router } from '@angular/router';
import { HttpHeaders } from '@angular/common/http';
import { AUTHORIZATION_HEADER, TOKEN_HEADER } from '../../model/session-token';

@Component({
    selector: 'app-profile',
    templateUrl: './profile.component.html',
    styleUrls: ['./profile.component.css']
})

export class ProfileComponent implements OnInit {
    rankId;
    rank: Rank = new Rank(0, 0, "", 0, null);
    ranks: Rank[];
    role: Role = {id:0, name:""};
    user: User;
    token: SessionToken = null;

  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient, private validate: LoginCredentialsService,
  private rout: Router) {
  }

  ngOnInit() {
    
    //this.ranks = localStorage.getItem(this.ranks);
    this.token = this.validate.getToken();
    if (this.token != null) {
      this.user = this.validate.getUser();
      
      this.headers = this.headers.append(AUTHORIZATION_HEADER, this.token.username);
      this.headers = this.headers.append(TOKEN_HEADER, this.token.token);
    }
    else {
      this.rout.navigate(["401"]);
    }
  }

  public fetchData() {
    if (this.token != null) {
      this.rank.id = 0;
      this.rank.rankName = "";
      this.rank.topic = null;
      this.rank.relativeWeight = 0;
      this.rank.meritThreshold = 0;
      console.log(this.token);
      this.http.get('http://localhost:8085/api/rest/ranks/getById/' + this.rankId + '/', { headers: this.headers }).subscribe(
        data => {
          console.log("test");
          this.rank.rankName = data["name"],
            this.rank.topic = data["topic"],
            this.rank.relativeWeight = data["relativeWeight"],
            this.rank.meritThreshold = data["meritThreshold"]
        },
        err => {
          this.rank.rankName = "error";
          this.rank.topic = null;
          this.rank.relativeWeight = 0;
          this.rank.meritThreshold = 0;
        }
      )
    }
    else {
      this.rout.navigate(["401"]);
    }
  }

  //  getRanks(){
  //    this.httpClient.get(`https://my-json-server.typicode.com/mjsnee/fake-json-server/user-ranks`)
  //    .subscribe(
  //      (data:any[]) => {
  //        if(data.length) {
  //          this.merit = data[0].merit;
  //        }
  //        }
  //  }
}

