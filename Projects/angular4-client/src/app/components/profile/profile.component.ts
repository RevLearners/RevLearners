import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Rank } from '../../model/rank';
import { User } from '../../model/user';
import { LoginCredentialsService } from '../../services/login-credentials.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  public rankId;
  public rank: Rank = null;  
  ranks:Rank[];
  user: User;
  

  constructor(private http:HttpClient, private validate:LoginCredentialsService) { }

  ngOnInit() {
    this.user = this.validate.getUser();
    }
  
  public fetchData(){
               this.rank.id = 0;
             this.rank.name = "";
            this.rank.topic = null;
   this.rank.heirarchy_rank = 0;
   this.rank.merit_threshhold = 0;
   
   this.http.get('http://localhost:4200/api/rest/ranks/getById/' + this.rankId + '/').subscribe(
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
//      }
//  }
  
}

