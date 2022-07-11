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
    CartViewComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
