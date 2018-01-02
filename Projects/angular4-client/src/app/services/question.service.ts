import {Observable} from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import 'rxjs/add/observable/empty';
import 'rxjs/add/operator/map';

import {HttpClient} from '@angular/common/http';

import {Question} from '../model/question';
import {Injectable} from '@angular/core';
import {ChallengeAttempt} from '../model/challenge-attempt';
import {Challenge} from '../model/challenge';
import {LoginCredentialsService} from "./login-credentials.service";

const CREATE_CHALLENGE_URL = 'http://localhost:8085/api/rest/challenges/createChallenge';
const USER_CHALLENGES_BASE_URL = 'http://localhost:8085/api/rest/challenges/getChallengesByUser';
const CHALLENGE_BY_ID_BASE_URL = 'http://localhost:8085/api/rest/challenges/getChallengeById';

const CREATE_ATTEMPT_URL = 'http://localhost:8085/api/rest/challenges/createAttempt';
const ATTEMPT_BY_ID_BASE_URL = 'http://localhost:8085/api/rest/challenges/getChallengeAttempt';
const USER_ATTEMPTS_BASE_URL = 'http://localhost:8085/api/rest/challenges/getUserChallengeAttempts';

const DEFAULT_QUESTION_COUNT = 5;

@Injectable()
export class QuestionService {

    constructor(private http: HttpClient, private creds: LoginCredentialsService) {
    }

    public generateChallenge(topicId: number, receiverId: number): Observable<any> {
        const requestOptions = {headers: this.creds.prepareAuthHeaders()};

        const userId = this.creds.getUser().id;
        const requestBody = {
            topicId: topicId,
            senderId: userId,
            receiverIds: [receiverId],
            numQuestions: DEFAULT_QUESTION_COUNT
        };
        return this.http.post(CREATE_CHALLENGE_URL, requestBody, requestOptions);
    }

    public submitNewQuestion(newQuestion: Question): Observable<any> {

        const questionInfo = {
            topic: newQuestion.topic,
            text: newQuestion.text,
            options: newQuestion.options,
            explanation: newQuestion.explanation
        }

        return this.http.post('http://localhost:8085/api/rest/challenges/createQuestion', questionInfo, { headers: this.creds.prepareAuthHeaders()});                 //Observable.empty();
    }

    public getChallengeById(id: number): Observable<Challenge> {
        const attemptUrl = `${CHALLENGE_BY_ID_BASE_URL}/${id}`;
        return this.http.get(attemptUrl, {headers: this.creds.prepareAuthHeaders()})
            .map((res: any) => {
                return new Challenge(
                    res.id,
                    res.quiz,
                    res.users,
                    res.attempts
                );
            });
    }

    public getChallengesForUser(): Observable<Challenge[]> {
        const userChallengsUrl = USER_CHALLENGES_BASE_URL + '/' + this.creds.getUser().id;
        return this.http.get(userChallengsUrl, {headers: this.creds.prepareAuthHeaders()})
            .map((res: any[]) => {
                return res.map(item => {
                    return new Challenge(
                        item.id,
                        item.quiz,
                        item.users,
                        item.attempts
                    );
                });
            });
    }

    public getUserAttemptsForChallenge(id: number): Observable<ChallengeAttempt[]> {
        return this.http.get<ChallengeAttempt[]>(
            `${USER_ATTEMPTS_BASE_URL}/${this.creds.getUser().id}/${id}`,
            {headers: this.creds.prepareAuthHeaders()}
        );
    }

    public getAttemptById(id: number): Observable<ChallengeAttempt> {
        return this.http.get<ChallengeAttempt>(
            `${ATTEMPT_BY_ID_BASE_URL}/${id}`,
            {headers: this.creds.prepareAuthHeaders()}
        );
    }

    public submitAttempt(completedChallenge: CompletedChallenge): Observable<ChallengeAttempt> {
        return this.http.post<ChallengeAttempt>(CREATE_ATTEMPT_URL, completedChallenge, {headers: this.creds.prepareAuthHeaders()});
    }

}


export class CompletedChallenge {
    userId: number;
    challengeId: number;
    answers: Object;

    constructor(userId: number, challengeId: number, answers: Object) {
        this.userId = userId;
        this.challengeId = challengeId;
        this.answers = answers;
    }
}
