
export class User {
    id: number;
    firstname: string;
    middlename: string;
    lastname: string;
    email: string;
    username: string;
    password: string;

    constructor(id, username) {
        this.id = id;
        this.username = username;
    }
}
