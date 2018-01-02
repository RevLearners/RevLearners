import 'rxjs/add/observable/of';
import 'rxjs/add/observable/empty';
import 'rxjs/add/operator/map';

import { Message } from '../model/message';
import { Notification } from '../model/notification';
import { HttpClient } from '@angular/common/http';

import { BackendService } from './backend.service';
import { Injectable } from '@angular/core';

@Injectable()
export class MonitorService {

    constructor(private bs: BackendService) {}

    // }

    // public getMessageCount(){
    //     return this.messageCount;
    // }

    // public getNotificationCount(){
    //     return this.notificationCount;
    // }

    // public invokeMessageMonitor() {
    //     this.msgAlive = true;
    //     IntervalObservable.create(2000
    //     ).takeWhile(() => this.msgAlive) // only fires when component is alive
    //         .subscribe(() => {
    //             this.bs.getMessages().subscribe((data: any) => {
    //                 if (this.messageCount < this.msgArr.length) {
    //                     localStorage.setItem(MSG_CACHE, JSON.stringify(data));
    //                     this.msgs = data;
    //                     this.messageCount = this.msgArr.length;
    //                 }
    //             });
    //         }
    //     )
    // }

    // public stopMessageMonitor() {
    //     this.msgAlive = false;
    // }

    // public invokeNotificationMonitor() {
    //     this.msgAlive = true;
    //     IntervalObservable.create(2000
    //     ).takeWhile(() => this.msgAlive) // only fires when component is alive
    //         .subscribe(() => {
    //             this.bs.getMessages().subscribe((data: any) => {
    //                 if (this.notificationCount < this.msgArr.length) {
    //                     localStorage.setItem(NOTIF_CACHE, JSON.stringify(data));
    //                     this.msgs = data;
    //                     this.notificationCount = this.msgArr.length;
    //                 }
    //             });
    //         }
    //     )
    // }

    // public stopNotificationMonitor() {
    //     this.notifAlive = false;
    // }

}