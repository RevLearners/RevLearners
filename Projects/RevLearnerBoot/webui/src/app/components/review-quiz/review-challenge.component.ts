import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {QuestionService} from '../../services/question.service';
import {Quiz} from '../../model/quiz';

@Component({
    selector: 'app-review-quiz',
    templateUrl: '../../../../src/main/resources/public/review-challenge.component.html',
    styleUrls: [ '../../../../src/main/resources/public/review-challenge.css']
})
export class ReviewChallengeComponent implements OnInit {

    quiz: Quiz;
    constructor(private questionService: QuestionService, private activatedRoute: ActivatedRoute) {
        this.activatedRoute.params.subscribe(params => {
            console.log(params);
            const id: number = +(params['id']);
            this.questionService.getQuizById(id).subscribe(
                (quiz: Quiz) => this.quiz = quiz,
                console.log
            );
        });
    }

    ngOnInit() {
    }

}
