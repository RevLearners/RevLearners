import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {BackendService} from '../../services/backend.service';
import {Rank} from "../../model/rank";
import {QuestionService} from "../../services/question.service";
import { SessionToken } from '../../model/session-token';
import { LoginCredentialsService } from '../../services/login-credentials.service';
import { Router } from '@angular/router';

@Component({
    selector: 'app-create-challenge',
    templateUrl: './create-challenge.component.html',
    styleUrls: ['./create-challenge.component.css'],
})

export class CreateChallengeComponent implements OnInit {

    token: SessionToken;
    rForm: FormGroup;
    chosenTopic: number;
    chosenChallenger: number;
    challengeSuccess: boolean;
    //Temporary Table of Topics
    public topics = [];

    //Temporary Table of Challengers
    public challengers = [];

    constructor(private fb: FormBuilder, private dataService: BackendService, private questionService: QuestionService,
    private lcs: LoginCredentialsService, private rout: Router) {
        this.rForm = fb.group({
            'topic': [null, Validators.required],
            'challengers': [null, Validators.required],
            'validate': ''
        });
    }

    ngOnInit() {
        this.token = this.lcs.getToken();
        if(this.token != null){
        this.dataService.getUsers().subscribe(
            (data: any) => {
                this.challengers = data;
                console.log("challengers: ", data);
            },
            console.log
        );
        this.dataService.getTopics().subscribe(
            (topics: any[]) => {
                console.log(" ====== topics =======");
                console.log(topics);
                this.topics = topics;
            },
            console.log
        )
    }
    else{
      this.rout.navigate(["401"]);
    }
}


    addPost(post) {
        console.log(post.challengers);
        this.chosenChallenger = post.challengers;
        this.chosenTopic = post.topic;
        if (!this.chosenChallenger || !this.chosenTopic) {
            return
        }
        this.challengeSuccess = true;
        this.questionService.generateChallenge(this.chosenTopic, this.chosenChallenger).subscribe(
            (challenge) => {
                console.log("generated challenge", challenge)
            },
            console.log
        );
    }

    resetForm() {
        this.chosenChallenger = null;
        this.challengeSuccess = false;
    }

    getRankInTopic(challenger: any): string {
        for(const rank of challenger.ranks) {
            if (rank.topicId == this.chosenTopic)
                return rank.rankName;
        }
        return null;
    }
}
