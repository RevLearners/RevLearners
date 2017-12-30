import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
    selector: 'app-create-challenge',
    templateUrl: './CreateChallenge.component.html',
    styleUrls: ['./CreateChallenge.component.css'],
})

export class CreateChallengeComponent {

    rForm: FormGroup;
    chosenTopic: String = '';
    chosenChallenger: String = '';
    //Temporary Table of Topics
    public topics = [
        "Java",
        "SQL",
        "HTML/CSS",
        "JavaScript",
        'Hibernate',
        "DevOps",
    ]

    //Temporary Table of Challengers
    public challengers = [
        { rank: 122, name: 'Xavier' },
        { rank: 123, name: 'Bobbert' },
        { rank: 124, name: 'Caleb' },
        { rank: 125, name: 'Matt' },
        { rank: 126, name: 'Sean' },
        { rank: 123, name: 'Bobbert' }
    ]

    constructor(private fb: FormBuilder) {
        this.rForm = fb.group({
            'topic': [null, Validators.required],
            'challengers': [null, Validators.required],
            'validate': ''
        });

    }

    addPost(post) {
        console.log(post.challengers);
        this.chosenChallenger = post.challengers;
        this.chosenTopic = post.topic;
    }

    resetForm() {
        this.chosenChallenger = '';
    }
}