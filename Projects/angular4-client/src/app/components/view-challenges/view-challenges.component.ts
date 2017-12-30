import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Quiz} from '../../model/quiz'
import {Question} from '../../model/question';
import {Topic} from '../../model/topic';
import {User} from '../../model/user';
import { LoginCredentialsService } from '../../services/login-credentials.service';

@Component({
  selector: 'app-view-challenges',
  templateUrl: './view-challenges.component.html',
  styleUrls: ['./view-challenges.component.css']
})
export class ViewChallengesComponent implements OnInit {

  quiz: Quiz;  
  quizzes:Quiz[];
  user: User;
  
  constructor(private http:HttpClient, private validate:LoginCredentialsService) { }

  ngOnInit() {
    this.user = this.validate.getUser();
    }
  
//  public fetchUserQuiz(){
//    
//    this.http.get('url').subscribe{
//      data => {
//        
//      }
//    }
//  }
  
  
}
