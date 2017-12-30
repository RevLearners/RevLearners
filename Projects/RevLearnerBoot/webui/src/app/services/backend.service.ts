import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';

export const backendUrl = 'http://localhost:8085/RevLearners';

@Injectable()
export class BackendService {
    constructor(private http: HttpClient) {
    }
}
