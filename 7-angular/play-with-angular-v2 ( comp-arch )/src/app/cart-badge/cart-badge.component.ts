import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-cart-badge',
  template: `
  <div>
      <i style="font-size:2em;color:tomato" class="fa fa-shopping-cart"></i>&nbsp;
      <span class="badge badge-danger">{{value}}</span>
      item(s) in cart
  </div>
 `
})
export class CartBadgeComponent implements OnInit {


  @Input() value = 0

  constructor() { }

  ngOnInit(): void {
  }

}
