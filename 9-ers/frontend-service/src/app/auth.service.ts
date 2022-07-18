import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {tap} from 'rxjs/operators'
import {BehaviorSubject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  authStream = new BehaviorSubject<any>({isLoggedIn: false})
  userDetails: any = {}

  constructor(
    private httpClient: HttpClient
  ) {
  }

  getToken() {
    return localStorage.getItem("auth-token") || null;
  }

  doLogin(credentials: object) {
    return this.httpClient.post("http://localhost:8181/login", credentials)
      .pipe(tap((response: any) => {
          const jwtToken = response.jwt;
          localStorage.setItem("auth-token", jwtToken)
          this.authStream.next({isLoggedIn: true})
        }
      ))
  }

  doLogout() {
    localStorage.removeItem("auth-token")
    this.authStream.next({isLoggedIn: false})
  }

  getUser() {
    return this.httpClient.get("http://localhost:8181/api/user")
      .pipe(tap((response: any) => {
        this.userDetails = response
      }))
  }


}
