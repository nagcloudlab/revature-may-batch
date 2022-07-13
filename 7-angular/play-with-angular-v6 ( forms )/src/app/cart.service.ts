import { Injectable } from '@angular/core';
import {BehaviorSubject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CartService {

  cartStream=new BehaviorSubject<any>([])

  cart:any={}

  addToCart(item:any,qty:number):void{
    let {id}=item;
    let cartLine=this.cart[id];
    if(!cartLine){
      cartLine={item,qty:qty}
    }else{
      cartLine={...cartLine,qty:cartLine.qty+qty}
    }
    if(cartLine.qty===0) {
      delete this.cart[id];
    }else {
      this.cart[id] = cartLine;
    }
    console.log(this.cart)
    this.cartStream.next(this.cart)
  }

  constructor() { }


}
