import { MessageStatus } from "./message-status";
import { User } from "./user";

export class Notification {
	id: number;
	senderId: number;
	receivers: User[];
	title: string;
	contents: string;
	time: Date;
	status: MessageStatus;
  
  constructor(id: number, senderId: number, receivers: User[],
              title: string, contents: string, time: Date,
              status: MessageStatus){
    this.id = id;
    this.senderId = senderId;
    this.receivers = receivers;
    this.title = title;
    this.contents = contents;
    this.time = time;
    this.status = status;
  }
  
  
}