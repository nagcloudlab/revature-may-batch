import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {AboutComponent} from "./about/about.component";
import {LoginComponent} from "./login/login.component";
import {NotFoundComponent} from "./not-found/not-found.component";
import {ContactsListComponent} from "./contacts-list/contacts-list.component";
import {ContactsDetailComponent} from "./contacts-detail/contacts-detail.component";
import {ContactsHomeComponent} from "./contacts-home/contacts-home.component";
import {CommonModule} from "@angular/common";
import {ContactsResolver} from "./contacts.resolver";
import {Guard1Guard} from "./guard1.guard";
import { Guard2Guard } from './guard2.guard';
import {Guard3Guard} from "./guard3.guard";

const routes: Routes = [
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'contacts',
    component: ContactsHomeComponent,
    canActivate:[Guard1Guard,Guard2Guard],
    canDeactivate:[Guard3Guard],
    children: [
      {
        path: '',
        component: ContactsListComponent,
        resolve: {
          contacts: ContactsResolver
        },
        children: [
          {
            path: ':cId',
            component: ContactsDetailComponent
          }
        ]
      },
    ]
  },
  {
    path: 'about',
    component: AboutComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: '**',
    component: NotFoundComponent
  }

];

@NgModule({
  declarations: [
    HomeComponent,
    AboutComponent,
    LoginComponent,
    NotFoundComponent,
    ContactsListComponent,
    ContactsDetailComponent,
    ContactsHomeComponent
  ],
  imports: [RouterModule.forRoot(routes), CommonModule],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
