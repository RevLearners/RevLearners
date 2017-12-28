import {Quiz} from './quiz';
import {User} from './user';
import {ChallengeAttempt} from './challenge-attempt';

export class Challenge{
    id: number;
    quiz: Quiz;
    users: User[];
    attempts: ChallengeAttempt[];   // we will receive this to backend

    constructor(id, quiz, users, attempts) {
        this.id = id;
        this.quiz = quiz;
        this.users = users;
        this.attempts = attempts;
    }
}
