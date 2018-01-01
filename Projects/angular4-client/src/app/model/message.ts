import { MessageStatus } from "./message-status";
import { User } from "./user";

export class Message {
  id: number;
  contents: string;
  time: Date;
  title: string;  
  senderId: number;
  receivers: User[];
  attachment: File;
  status: MessageStatus;
  
  constructor(id: number, contents: string, time: Date, title: string,
              senderId: number, receivers: User[], attachment: File,
              status: MessageStatus){
    this.id = id;
    this.contents = contents;
    this.time = time;
    this.title = title;
    this.senderId = senderId;
    this.receivers = receivers;
    this.attachment = attachment;
    this.status = status;
  }
  
}