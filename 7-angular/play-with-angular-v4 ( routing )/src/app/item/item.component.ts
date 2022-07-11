import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { CartService } from '../cart.service';
import {ItemService} from "../item.service";

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.scss']
})
export class ItemComponent implements OnInit {


  @Input("value")
  item: any = {}

  @Output()
  buy = new EventEmitter()

  currentTab = 1

  cartQty=0;

  reviews:Array<any> = []

  handleBuy() {
    //this.buy.emit({ ...this.item })
    this.cartService.addToCart(this.item,1)
  }

  handleCartQty(qty:number){
    //..
    this.cartService.addToCart(this.item,qty)
  }

  handleTabChange(event: Event, tabIndex: number) {
    this.currentTab = tabIndex
    if(this.currentTab===3){
      this.reviews=this.itemService.getReviews(this.item.id)
    }
  }

  isTabSelected(tabIndex: number) {
    return this.currentTab === tabIndex
  }

  constructor(
    private cartService: CartService,
    private itemService:ItemService
  ) { }

  ngOnInit(): void {
    this.cartService.cartStream.subscribe({
      next:cart=>{
        let cartLine=cart[this.item.id]
        if(cartLine)
        this.cartQty=cartLine.qty;
        else{
          this.cartQty=0
        }
      }
    })
  }

}
