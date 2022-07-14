import { Component } from '@angular/core';
import { AuthService } from './auth.service';
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend-service';
  isUserLoggedIn = false;

  constructor(
    private auth: AuthService,
    private router: Router
  ){}

  ngOnInit(){
    this.isUserLoggedIn=this.auth.isLoggedIn()
    console.log(this.isUserLoggedIn)
    this.auth.authStream.subscribe({
      next:(au:any)=>{
          this.isUserLoggedIn=au.isLoggedIn
      }
    })
  }

  handleLogout(){
    this.auth.doLogout()
    this.router.navigate([''])
  }

}
