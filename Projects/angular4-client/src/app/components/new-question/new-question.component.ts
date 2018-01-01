import { Component, OnInit } from '@angular/core';
import { Question } from '../../model/question';
import { QuestionOption } from '../../model/question-option';
import { Topic } from '../../model/topic';
import { QuestionService } from '../../services/question.service';
import { Router } from '@angular/router';

import { AUTHORIZATION_HEADER, TOKEN_HEADER } from '../../model/session-token';
import { User } from '../../model/user';
import { SessionToken } from '../../model/session-token';
import { LoginCredentialsService } from '../../services/login-credentials.service';

@Component({
    selector: 'app-new-question',
    templateUrl: './new-question.component.html',
    styleUrls: ['./new-question.component.css']
})
export class NewQuestionComponent implements OnInit {

    user: User;
    token: SessionToken;

    newQuestion: Question = new Question(-1, '', '', [
        new QuestionOption(-1, '', false)
    ]);

    topics: Topic[] = [];


    constructor(private questionService: QuestionService, private router: Router,
        private lcs: LoginCredentialsService) {
    }

    ngOnInit() {
        this.token = this.lcs.getToken();
        if (this.token != null) {
            this.questionService.getAllTopics().subscribe(
                data => {
                    this.topics = data;
                    this.newQuestion.topic = this.topics[0];
                },
                console.log
            );
        }
        else{
            this.router.navigate(["401"]);
          }
    }

    addNewOption(): void {
        if (this.token != null) {
            this.newQuestion.options.push(new QuestionOption(-1, '', false));
        }
        else{
            this.router.navigate(["401"]);
          }
    }

    removeOption(opt: QuestionOption): void {
        if (this.token != null) {
            const options: QuestionOption[] = this.newQuestion.options;
            options.splice(options.indexOf(opt), 1);
        }
        else{
            this.router.navigate(["401"]);
          }
    }

    submitNewQuestion(): void {
        // todo: validate new question
        if (this.token != null) {
            this.questionService.submitNewQuestion(this.newQuestion).subscribe(
                console.log,
                console.log,
                () => this.router.navigate(['/profile'])
            );
        }
        else{
          this.router.navigate(["401"]);
        }
    }

    selectOption(option: QuestionOption) {
        if (this.token != null) {
            for (const opt of this.newQuestion.options) {
                opt.isCorrect = false;
            }
            option.isCorrect = true;
            console.log(this.newQuestion);
        }
        else{
          this.router.navigate(["401"]);
        }
    }
}
