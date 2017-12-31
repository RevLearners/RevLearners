import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import {User} from '../../model/user';
import {Topic} from '../../model/topic';

import {LoginCredentialsService} from '../../services/login-credentials.service';


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
  }
  
  //userScores = userScore[];

  constructor(private validate:LoginCredentialsService) { }

  ngOnInit() {
    this.user = this.validate.getUser();
    }
  
  

}
