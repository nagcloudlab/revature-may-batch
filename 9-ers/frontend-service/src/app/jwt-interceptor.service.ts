import {Injectable} from '@angular/core';
import {HttpRequest, HttpHandler, HttpEvent, HttpInterceptor} from '@angular/common/http';
import {Observable} from 'rxjs';
import { AuthService } from './auth.service';


@Injectable()
export class JwtInterceptorService implements HttpInterceptor {

  constructor(private authService: AuthService) {
  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    request = request.clone({
      setHeaders: {Authorization: `Bearer ${this.authService.getToken()?this.authService.getToken():''}`}
    });
    return next.handle(request);
  }
}
