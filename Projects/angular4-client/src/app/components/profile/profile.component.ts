import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  public rankId;
  public rank = {
               id: "",
             name: "",
            topic: "",
   relativeWeight: "",
   meritThreshold: ""
  }
  
  constructor(private http: HttpClient) { }

  ngOnInit() {
  }
  
  public fetchData(){
               this.rank.id = "Pending",
             this.rank.name = "Pending",
            this.rank.topic = "Pending",
   this.rank.relativeWeight = "Pending",
   this.rank.meritThreshold = "Pending"
   
   this.http.get('http://localhost:4200/api/rest/ranks/getById/' + this.rankId + '/').subscribe(
     data => {
       console.log("test");
       this.rank.name = data["name"],
       this.rank.topic = data["topic"],
       this.rank.relativeWeight = data["relativeWeight"],
       this.rank.meritThreshold = data["meritThreshold"]
     },
     err => {
       this.rank.name = "error";
       this.rank.topic = "error";
       this.rank.relativeWeight = "error";
       this.rank.meritThreshold = "error";
     }
  )
}
  
}

