import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {BackendService} from '../../services/backend.service';
import {Rank} from "../../model/rank";
import {QuestionService} from "../../services/question.service";

@Component({
    selector: 'app-create-challenge',
    templateUrl: './create-challenge.component.html',
    styleUrls: ['./create-challenge.component.css'],
})

export class CreateChallengeComponent implements OnInit {

    rForm: FormGroup;
    chosenTopic: number;
    chosenChallenger: number;
    challengeSuccess: boolean;
    //Temporary Table of Topics
    public topics = [];

    //Temporary Table of Challengers
    public challengers = [];

    constructor(private fb: FormBuilder, private dataService: BackendService, private questionService: QuestionService) {
        this.rForm = fb.group({
            'topic': [null, Validators.required],
            'challengers': [null, Validators.required],
            'validate': ''
        });
    }

    ngOnInit() {
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
        for (const rank: Rank of challenger.ranks) {
            if (rank.topicId == this.chosenTopic)
                return rank.rankName;
        }
        return null;
    }
}
