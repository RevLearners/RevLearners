import {HttpClient} from '@angular/common/http';
import {Component, OnInit} from '@angular/core';

import {Rank} from '../../model/rank';
import {User} from '../../model/user';
import {LoginCredentialsService} from '../../services/login-credentials.service';
import {AuthenticationService} from '../../services/authentication.service';
import {SessionToken} from '../../model/session-token';
import {HttpHeaders} from '@angular/common/http';

import {AUTHORIZATION_HEADER, TOKEN_HEADER} from '../../model/session-token';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
  
export class ProfileComponent implements OnInit {
  rankId;
  rank: Rank = new Rank(0, 0, "", 0, null);
  ranks: Rank[];
  user: User;
  token: SessionToken = null;

  private headers = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private http: HttpClient, private validate: LoginCredentialsService) {
  }

  ngOnInit() {
    this.user = this.validate.getUser();
    this.token = this.validate.getToken();
    this.headers = this.headers.append(AUTHORIZATION_HEADER, this.token.username);
    this.headers = this.headers.append(TOKEN_HEADER, this.token.token);
  }

  public fetchData() {
    this.rank.id = 0;
    this.rank.name = "";
    this.rank.topic = null;
    this.rank.heirarchy_rank = 0;
    this.rank.merit_threshhold = 0;
    console.log(this.token);
    this.http.get('http://localhost:4200/api/rest/ranks/getById/' + this.rankId + '/', {headers: this.headers}).subscribe(
      data => {
        console.log("test");
        this.rank.name = data["name"],
          this.rank.topic = data["topic"],
          this.rank.heirarchy_rank = data["relativeWeight"],
          this.rank.merit_threshhold = data["meritThreshold"]
      },
      err => {
        this.rank.name = "error";
        this.rank.topic = null;
        this.rank.heirarchy_rank = 0;
        this.rank.merit_threshhold = 0;
      }
    )
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

