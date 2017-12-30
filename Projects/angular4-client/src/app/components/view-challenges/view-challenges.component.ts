import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
    selector: 'view-challenge',
    template: './view-challenge.component.html'
})

export class ViewChallengeComponent{

    constructor(private http:HttpClient){

    }
}