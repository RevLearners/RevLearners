import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import {User} from '../../model/user';
import {Topic} from '../../model/topic';

import {LoginCredentialsService} from '../../services/login-credentials.service';
import { BackendService } from '../../services/backend.service';


@Component({
  selector: 'app-leaderboard',
  templateUrl: './leaderboard.component.html',
  styleUrls: ['./leaderboard.component.css']
})
export class LeaderboardComponent implements OnInit {

  user: User;

  userScore: {
    topic: Topic,
    user: User,
    score: number
  };

  //userScores = userScore[];

  users: User[];
  public topics = []
  selectedTopic = '';

  constructor(private validate:LoginCredentialsService, private dataservice: BackendService) { }

  ngOnInit() {
    this.user = this.validate.getUser();

    this.dataservice.getTopics().subscribe(
      (data: any) =>{
          this.topics = data;
          console.log("Topic Data");
          console.log(data);
      }
  )

    this.dataservice.getUsers().subscribe(
      (data: any) =>{
          this.users = data;
          console.log("Data: " + data);
          console.log(data);
      }
  )

    }



}
