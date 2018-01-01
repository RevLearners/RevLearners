import {Observable} from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import 'rxjs/add/observable/empty';
import 'rxjs/add/operator/map';

import {HttpClient} from '@angular/common/http';

import {Question} from '../model/question';
import {Quiz} from '../model/quiz';
import {QuestionOption} from '../model/question-option';
import {Topic} from '../model/topic';
import {Injectable} from '@angular/core';
import {ChallengeAttempt} from '../model/challenge-attempt';
import {Challenge} from '../model/challenge';
import {User} from '../model/user';


export const TOPICS: Topic[] = [
    new Topic(-1, 'Hibernate'),
    new Topic(-1, 'Core Java'),
    new Topic(-1, 'Design Patterns'),
    new Topic(-1, 'Html/CSS/Javascript')
];

export const QUIZ: Quiz = new Quiz(
    1,
    null,
    [
        new Question(
            1,
            'a this is a question this is a question this is a question this is a ' +
            'question this is a question this is a question, deal with it ',
            'the correct answer is whatever i say it is the correct ' +
            'answer is whatever i say it is the correct answer is whatever i say it is',
            [
                new QuestionOption(
                    1,
                    'this is an option; deal with it',
                    false
                ),
                new QuestionOption(
                    2,
                    'this is an option; deal with it',
                    true
                ),
                new QuestionOption(
                    3,
                    'this is an option; deal with it',
                    false
                ),
            ]
        ),
        new Question(
            1,
            'b this is a question this is a question this is a question this is a question this is a question this is a question, deal with it ',
            'the correct answer is whatever i say it is the correct answer is whatever i say it is the correct answer is whatever i say it is',
            [
                new QuestionOption(
                    1,
                    'this is an option; deal with it',
                    false
                ),
                new QuestionOption(
                    2,
                    'this is an option; deal with it',
                    true
                ),
                new QuestionOption(
                    3,
                    'this is an option; deal with it',
                    false
                ),
            ]
        ),

        new Question(
            1,
            'c this is a question this is a question this is a question this is a question this is a question this is a question, deal with it ',
            'the correct answer is whatever i say it is the correct answer is whatever i say it is the correct answer is whatever i say it is',
            [
                new QuestionOption(
                    1,
                    'this is an option; deal with it',
                    false
                ),
                new QuestionOption(
                    2,
                    'this is an option; deal with it',
                    true
                ),
                new QuestionOption(
                    3,
                    'this is an option; deal with it',
                    false
                ),
            ]
        ),

        new Question(
            1,
            'c this is a question this is a question this is a question this is a question this is a question this is a question, deal with it ',
            'the correct answer is whatever i say it is the correct answer is whatever i say it is the correct answer is whatever i say it is',
            [
                new QuestionOption(
                    1,
                    'this is an option; deal with it',
                    false
                ),
                new QuestionOption(
                    2,
                    'this is an option; deal with it',
                    true
                ),
                new QuestionOption(
                    3,
                    'this is an option; deal with it',
                    false
                ),
            ]
        ),

        new Question(
            1,
            'd this is a question this is a question this is a question this is a question this is a question this is a question, deal with it ',
            'the correct answer is whatever i say it is the correct answer is whatever i say it is the correct answer is whatever i say it is',
            [
                new QuestionOption(
                    1,
                    'this is an option; deal with it',
                    false
                ),
                new QuestionOption(
                    2,
                    'this is an option; deal with it',
                    true
                ),
                new QuestionOption(
                    3,
                    'this is an option; deal with it',
                    false
                ),
            ]
        )

    ]
);

export const USER1: User = new User(1, 'userOne');
export const USER2: User = new User(2, 'userTwo');

export const CHALLENGE: Challenge = new Challenge(
    1,
    QUIZ,
    [USER1, USER2],
    []
);

export const ATTEMPT: ChallengeAttempt = new ChallengeAttempt(
    1,
    USER1,
    CHALLENGE,
    50,
    QUIZ.questions.map(q => q.options[0])
);


@Injectable()
export class QuestionService {

    topics: Topic[] = null;

    constructor(private http: HttpClient) {
    }

    public generateQuizByTopic(topic: Topic): Observable<Quiz> {
        return Observable.of(QUIZ);
    }

    public getQuizById(id: number): Observable<Quiz> {
        return Observable.of(QUIZ);
    }

    public getChallengeById(id: number): Observable<Challenge> {
        return Observable.of(CHALLENGE);
    }

    public getAttemptById(id: number): Observable<ChallengeAttempt> {
        return Observable.of(ATTEMPT);
    }

    public submitAttempt(completedChallenge: ChallengeAttempt): Observable<ChallengeAttempt> {
        return Observable.of(ATTEMPT);
    }

    public submitNewQuestion(newQuestion: Question): Observable<any> {
        return Observable.empty();
    }

}
