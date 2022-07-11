import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ItemService {


  items = [
    {
      id:1,
      name: "VEG",
      price: 100.00,
      currencyCode: 'USD',
      description: 'Veg is always yummy',
      isAvailable: true,
      imgPath: "assets/veg.png",
      makeDate: Date.now()
    },
    {
      id:2,
      name: "Non-VEG",
      price: 200.00,
      offPrice: 10,
      description: 'Non-veg is not always yummy',
      isAvailable: true,
      imgPath: "assets/non-veg.jpg",
      makeDate: Date.now()
    },
  ]

  constructor() { }

  getItems(){
    return this.items;
  }

  getReviews(itemId:number){
    return [
      { stars: 5, body: 'sample-review-1', who: 'who1' },
      { stars: 1, body: 'sample-review-2', who: 'who2' }
    ]
  }

}
