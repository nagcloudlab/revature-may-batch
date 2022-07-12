import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {HomeComponent} from './home/home.component';
import {AboutComponent} from './about/about.component';
import {LoginComponent} from './login/login.component';
import {RouterModule, Routes} from "@angular/router";
import {NotFoundComponent} from './not-found/not-found.component';
import {ContactListComponent} from './contact-list/contact-list.component';
import {ContactDetailComponent} from './contact-detail/contact-detail.component';

const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {
    path: 'contact',
    // component:ContactHomeComponent,
    children: [
      {
        path: '', component: ContactListComponent,
        children: [
          {path: ':cname', component: ContactDetailComponent},
        ]
      },
      // {path: ':cname', component: ContactDetailComponent},
    ]
  },
  {path: 'about', component: AboutComponent},
  {path: 'login', component: LoginComponent},
  {path: '**', component: NotFoundComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutComponent,
    LoginComponent,
    NotFoundComponent,
    ContactListComponent,
    ContactDetailComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
