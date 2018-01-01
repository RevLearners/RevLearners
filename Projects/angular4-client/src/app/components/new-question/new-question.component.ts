import {Component, OnInit} from '@angular/core';
import {Question} from '../../model/question';
import {QuestionOption} from '../../model/question-option';
import {Topic} from '../../model/topic';
import {QuestionService} from '../../services/question.service';
import {Router} from '@angular/router';
import {BackendService} from "../../services/backend.service";

@Component({
    selector: 'app-new-question',
    templateUrl: './new-question.component.html',
    styleUrls: ['./new-question.component.css']
})
export class NewQuestionComponent implements OnInit {


    newQuestion: Question = new Question(-1, '', '', [
        new QuestionOption(-1, '', false)
    ]);

    topics: any[] = [];

    constructor(private dataService: BackendService, private questionService: QuestionService, private router: Router) {
        this.dataService.getTopics().subscribe(
            (data: any[]) => {
                this.topics = data;
                this.newQuestion.topic = this.topics[0];
            },
            console.log
        );
    }

    ngOnInit() {
    }

    addNewOption(): void {
        this.newQuestion.options.push(new QuestionOption(-1, '', false));
    }

    removeOption(opt: QuestionOption): void {
        const options: QuestionOption[] = this.newQuestion.options;
        options.splice(options.indexOf(opt), 1);
    }

    submitNewQuestion(): void {
        // todo: validate new question
        this.questionService.submitNewQuestion(this.newQuestion).subscribe(
            console.log,
            console.log,
            () => this.router.navigate(['/profile'])
        );
    }

    selectOption(option: QuestionOption) {
        for (const opt of this.newQuestion.options) {
            opt.isCorrect = false;
        }
        option.isCorrect = true;
        console.log(this.newQuestion);
    }
}
