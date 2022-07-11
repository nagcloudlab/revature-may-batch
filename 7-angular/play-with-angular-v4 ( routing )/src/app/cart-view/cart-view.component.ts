import { Component, OnInit } from '@angular/core';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-cart-view',
  templateUrl: './cart-view.component.html',
  styleUrls: ['./cart-view.component.scss']
})
export class CartViewComponent implements OnInit {

  cart:any={}

  constructor(private cartService:CartService) { }

  ngOnInit(): void {
    this.cart=this.cartService.cart
  }

}
