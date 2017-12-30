import { MessageStatus } from "./message-status";
import { User } from "./user";

export class Notification {
	id: number;
	sender: User;
	receivers: User[];
	title: string;
	contents: string;
	time: Date;
	status: MessageStatus;
}