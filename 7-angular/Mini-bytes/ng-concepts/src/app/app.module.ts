import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BarModule } from './bar/bar.module';
import {FooModule} from "./foo/foo.module";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule } from '@angular/forms';

import {AutoCompleteModule} from 'primeng/autocomplete';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {CalendarModule} from 'primeng/calendar';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    FooModule,
    BarModule,
    AutoCompleteModule,
    CalendarModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
