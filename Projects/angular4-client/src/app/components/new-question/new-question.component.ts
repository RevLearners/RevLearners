import { Component, OnInit } from '@angular/core';
import { Question } from '../../model/question';
import { QuestionOption } from '../../model/question-option';
import { QuestionService } from '../../services/question.service';
import { Router } from '@angular/router';

import { LoginCredentialsService } from '../../services/login-credentials.service';
import { BackendService } from "../../services/backend.service";

@Component({
    selector: 'app-new-question',
    templateUrl: './new-question.component.html',
    styleUrls: ['./new-question.component.css']
})
export class NewQuestionComponent implements OnInit {

    newQuestion: Question = new Question(-1, null, null, [
        new QuestionOption(-1, null, false)
    ]);

    topics: any[] = [];

    constructor(private dataService: BackendService, private questionService: QuestionService,
        private router: Router, private creds: LoginCredentialsService) {
        console.log(this.newQuestion);
    }

    ngOnInit() {
        if (this.creds.getToken() != null) {
                this.dataService.getTopics().subscribe(
                    data => {
                        this.topics = data;
                        this.newQuestion.topic = this.topics[0];
                    },
                    console.log
                );
                this.dataService.getTopics().subscribe(
                    (data: any[]) => {
                        this.topics = data;
                        this.newQuestion.topic = this.topics[0];
                    },
                    console.log
                );
            }
        
        else{
            this.router.navigate(['401']);
        }
    }
    

    addNewOption(): void {
        if (this.creds.isLoggedIn()) {
            this.newQuestion.options.push(new QuestionOption(-1, '', false));
        }
        else {
            this.router.navigate(["401"]);
        }
    }

    removeOption(opt: QuestionOption): void {
        if (this.creds.isLoggedIn()) {
            const options: QuestionOption[] = this.newQuestion.options;
            options.splice(options.indexOf(opt), 1);
        }
        else {
            this.router.navigate(["401"]);
        }
    }

    submitNewQuestion(): void {
        // todo: validate new question
        if (this.creds.isLoggedIn()) {
            this.questionService.submitNewQuestion(this.newQuestion).subscribe(
                console.log,
                console.log,
                () => this.router.navigate(['/profile'])
            );
        }
        else {
            this.router.navigate(["401"]);
        }
    }

    selectOption(option: QuestionOption) {
        if (this.creds.isLoggedIn()) {
            for (const opt of this.newQuestion.options) {
                opt.isCorrect = false;
            }
            option.isCorrect = true;
            console.log(this.newQuestion);
        }
        else {
            this.router.navigate(["401"]);
        }
    }
}
