import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { TomComponent } from './tom/tom.component';
import { JerryComponent } from './jerry/jerry.component';
import { CountBadgeComponent } from './count-badge/count-badge.component';

@NgModule({
  declarations: [
    AppComponent,
    TomComponent,
    JerryComponent,
    CountBadgeComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
