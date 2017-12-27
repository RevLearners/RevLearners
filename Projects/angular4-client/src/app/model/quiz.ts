import {Question} from './question';
import {Topic} from './topic';

export class Quiz {
    id: number;
    questions: Question[];
    topic: Topic;

    constructor(id: number, topic: Topic, questions: Question[]) {
        this.id = id;
        this.topic = topic;
        this.questions = questions;
    }
}
