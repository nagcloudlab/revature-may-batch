import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  title = "FTGO"

  cart: Array<any> = []

  addToCart(item: any) {
    this.cart.push(item)
  }

}
