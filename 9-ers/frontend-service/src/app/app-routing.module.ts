import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ErsHomeComponent} from './ers-home/ers-home.component';
import {ErsRequestFormComponent} from './ers-request-form/ers-request-form.component';
import {ErsRequestListComponent} from "./ers-request-list/ers-request-list.component";
import {ReactiveFormsModule} from "@angular/forms";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {JwtInterceptorService} from "./jwt-interceptor.service";
import {CommonModule} from "@angular/common";
import {LoginComponent} from "./login/login.component";
import {AuthGuard} from "./auth.guard";

const routes: Routes = [
  {
    path: 'ers',
    component: ErsHomeComponent,
    canActivate:[AuthGuard],
    children: [
      {
        path: 'new',
        component: ErsRequestFormComponent
      },
      {
        path: 'view',
        component: ErsRequestListComponent
      }
    ]
  },
  {
    path: 'login',
    component: LoginComponent
  }
];

@NgModule({
  declarations: [
    ErsHomeComponent,
    ErsRequestFormComponent,
    ErsRequestListComponent,
    LoginComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    ReactiveFormsModule,
    HttpClientModule,
    CommonModule,
  ],
  exports: [RouterModule],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: JwtInterceptorService, multi: true},
  ]
})
export class AppRoutingModule {
}
