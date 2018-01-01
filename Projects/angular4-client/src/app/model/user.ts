import {Rank} from "./rank";

export class User {
    id: number;
    firstName: string;
    middleName: string;
    lastName: string;
    email: string;
    username: string;
    password: string;
    ranks: Rank[];

    constructor(id, username) {
        this.id = id;
        this.username = username;
    }
}
