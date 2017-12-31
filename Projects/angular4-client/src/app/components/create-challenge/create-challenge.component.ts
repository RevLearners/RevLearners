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

    constructor(private fb: FormBuilder, private dataservice: BackendService) {
        this.rForm = fb.group({
            'topic': [null, Validators.required],
            'challengers': [null, Validators.required],
            'validate': ''
        });

    }

    ngOnInit(){
        this.dataservice.getUsers().subscribe(
            (data: any) =>{
                this.challengers = data;
            }
        )
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