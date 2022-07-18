import {Component} from '@angular/core';
import {AuthService} from './auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'frontend-service';

  isLoggedIn = false;
  userDetails: any = {};

  constructor(private authService: AuthService) {
  }

  ngOnInit() {
    if (this.authService.getToken()) {
      this.isLoggedIn = true
      this.authService.getUser()
        .subscribe({
          next: (user: any) => {
            this.userDetails = user;
          }
        })
    }
    this.authService.authStream.subscribe({
      next: (data: any) => {
        if (data.isLoggedIn) {
          this.isLoggedIn = data.isLoggedIn
          this.authService.getUser()
            .subscribe({
              next: (user: any) => {
                this.userDetails = user;
              }
            })
        }
      }
    })
  }

  handleLogout() {
    this.authService.doLogout()
  }

}
