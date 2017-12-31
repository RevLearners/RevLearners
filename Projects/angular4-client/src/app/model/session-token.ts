export const AUTHORIZATION_HEADER: string = "Username";
export const TOKEN_HEADER: string = "Authorization";

export class SessionToken {
    username = '';
    token = '';
  

    constructor(username: string, token: string) {
        this.username = username;
        this.token = token;
    }
}