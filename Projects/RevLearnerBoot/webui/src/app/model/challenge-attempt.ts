import {User} from './user';
import {QuestionOption} from './question-option';
import {Challenge} from './challenge';

export class ChallengeAttempt {
    id: number;
    user: User;
    challenge: Challenge;    // we will send this to backend
    score: number;           // we will receive this from server
    selectedOptions: QuestionOption[];

    constructor(id, user, challenge, score, selectedOptions) {
        this.id = id;
        this.user = user;
        this.challenge = challenge;
        this.score = score;
        this.selectedOptions = selectedOptions;
    }
}
