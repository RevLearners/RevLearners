import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { BackendService } from '../../services/backend.service';

@Component({
    selector: 'app-create-challenge',
    templateUrl: './create-challenge.component.html',
    styleUrls: ['./create-challenge.component.css'],
})

export class CreateChallengeComponent {

    rForm: FormGroup;
    chosenTopic: String = '';
    chosenChallenger: String = '';
    //Temporary Table of Topics
    public topics = []

    //Temporary Table of Challengers
    public challengers = []

    constructor(private fb: FormBuilder, private dataservice: BackendService) {
        this.rForm = fb.group({
            'topic': [null, Validators.required],
            'challengers': [null, Validators.required],
            'validate': ''
        });

    }

    ngOnInit(){
        this.dataservice.getTopics().subscribe(
            (data: any) =>{
                this.topics = data;
                console.log("Topic Data");
                console.log(data);
            }
        )
        this.dataservice.getUsers().subscribe(
            (data: any) =>{
                this.challengers = data;
                console.log("Data: " + data);
                console.log(data);
            }
        )
    }

    addPost(post) {
        console.log("TEST!");
        console.log(post.challengers.firstName);
        this.chosenChallenger = post.challengers.firstName;
        this.chosenTopic = post.topic.topicName;
    }

    resetForm() {
        this.chosenChallenger = '';
    }
}