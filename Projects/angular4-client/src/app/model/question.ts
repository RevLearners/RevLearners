import {QuestionOption} from './question-option';
import {Topic} from './topic';

export class Question {
    id: number;
    text = '';
    explanation = '';
    options: QuestionOption[] = [];
    topic: Topic = null;
    points: number = 0.0;

    constructor(id: number, text: string, explanation: string, options: QuestionOption[]) {
        this.id = id;
        this.text = text;
        this.explanation = explanation;
        this.options = options;
        // this.points = ;
    }
}
