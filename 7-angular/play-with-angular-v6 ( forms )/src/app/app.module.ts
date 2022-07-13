import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { ItemListComponent } from './item-list/item-list.component';
import { ItemComponent } from './item/item.component';
import { CartBadgeComponent } from './cart-badge/cart-badge.component';
import { ReviewComponent } from './review/review.component';
import { DiscountPipe } from './discount.pipe';
import { HighlightDirective } from './highlight.directive';
import { CartViewComponent } from './cart-view/cart-view.component';
import {RouterModule, Routes} from "@angular/router";
import { HomeComponent } from './home/home.component';
import { ReviewFormComponent } from './review-form/review-form.component';
import {ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";

const routes:Routes=[
  {path:'',component:HomeComponent,pathMatch:'full'},
  {path:'items',component:ItemListComponent},
  {path:'cart',component:CartViewComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ItemListComponent,
    ItemComponent,
    CartBadgeComponent,
    ReviewComponent,
    DiscountPipe,
    HighlightDirective,
    CartViewComponent,
    HomeComponent,
    ReviewFormComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
