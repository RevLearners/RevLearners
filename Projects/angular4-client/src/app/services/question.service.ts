import {Observable} from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import 'rxjs/add/observable/empty';
import 'rxjs/add/operator/map';

import {HttpClient} from '@angular/common/http';

import {Question} from '../model/question';
import {Injectable} from '@angular/core';
import {ChallengeAttempt} from '../model/challenge-attempt';
import {Challenge} from '../model/challenge';
import {Quiz} from '../model/quiz';
import {LoginCredentialsService} from "./login-credentials.service";

const CREATE_CHALLENGE_URL = 'http://localhost:8085/api/rest/challenges/createChallenge';
const USER_CHALLENGES_BASE_URL = 'http://localhost:8085/api/rest/challenges/getChallengesByUser';
const CHALLENGE_BASE_URL = 'http://localhost:8085/api/rest/challenges/getChallengeById';

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

    public getAttemptById(id: number): Observable<ChallengeAttempt> {
        return Observable.empty();
    }

    public submitAttempt(completedChallenge: ChallengeAttempt): Observable<ChallengeAttempt> {
        return Observable.empty();
    }

    public submitNewQuestion(newQuestion: Question): Observable<any> {
        return Observable.empty();
    }

    public getChallengeById(id: number): Observable<Challenge> {
        const challengeUrl = CHALLENGE_BASE_URL + '/' + id;
        return this.http.get(challengeUrl, {headers: this.creds.prepareAuthHeaders()})
            .map((res: any) => {
                    return new Challenge(
                        res.id,
                        res.quiz,
                        res.users,
                        res.attempts
                    );
            });
    }

    getChallengesForUser(): Observable<Challenge[]> {
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

}
