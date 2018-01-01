import { MessageStatus } from "./message-status";
import { User } from "./user";

export class Certification {
  id: number;
  name: string;
  topic: string;
  user: User;
  status: MessageStatus;
  
  constructor(id: number, name: string, topic: string, user: User, status: MessageStatus){
    this.id = id;
    this.name = name;
    this.topic = topic;
    this.user = user;
    this.status = status;
  }
  
}