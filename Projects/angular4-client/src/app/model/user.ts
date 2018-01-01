import {Rank} from "./rank";

export class User {
    id: number;
    firstname: string;
    middlename: string;
    lastname: string;
    email: string;
    username: string;
    password: string;
    ranks: Rank[];

    constructor(id, username) {
        this.id = id;
        this.username = username;
    }
}
