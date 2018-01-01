import {Observable} from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import 'rxjs/add/observable/empty';
import 'rxjs/add/operator/map';

import {HttpClient, HttpHeaders} from '@angular/common/http';

import {Question} from '../model/question';
import {Injectable} from '@angular/core';
import {ChallengeAttempt} from '../model/challenge-attempt';
import {Challenge} from '../model/challenge';
import {Quiz} from '../model/quiz';
import {AUTHORIZATION_HEADER, TOKEN_HEADER} from "../model/session-token";
import {LoginCredentialsService} from "./login-credentials.service";
import {Topic} from '../model/topic';

const CHALLENGES_URL = 'http://localhost:8085/api/rest/challenges/createChallenge';
const DEFAULT_QUESTION_COUNT = 5;

@Injectable()
export class QuestionService {

    private headers = new HttpHeaders({'Content-Type': 'application/json'});
    private requestOptions = null;
    private topics = new Array<Topic>();

    constructor(private http: HttpClient, private creds: LoginCredentialsService) {
    }

    public generateChallenge(topicId: number, receiverId: number): Observable<any> {
        const token = this.creds.getToken();
        let headers = this.headers.append(AUTHORIZATION_HEADER, token.username);
        headers = this.headers.append(TOKEN_HEADER, token.token);
        const requestOptions = {headers: this.headers}

        const userId = this.creds.getUser().id;
        const requestBody = {
            topicId: topicId,
            senderId: userId,
            receiverIds: [receiverId],
            numQuestions: DEFAULT_QUESTION_COUNT
        };
        return this.http.post(CHALLENGES_URL, requestBody, requestOptions);
    }

    public getChallengeById(id: number): Observable<Challenge> {
        return Observable.empty();
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

    public getQuizById(id: number): Observable<Quiz> {
        return Observable.empty();
    }

    public getAllTopics(): Observable<Array<Topic>> {
        return Observable.empty();
    }

}
