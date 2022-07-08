import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.scss']
})
export class ItemListComponent implements OnInit {


  items = [
    {
      name: "VEG",
      price: 100.00,
      currencyCode: 'USD',
      description: 'Veg is always yummy',
      isAvailable: true,
      imgPath: "assets/veg.png",
      makeDate: Date.now()
    },
    {
      name: "Non-VEG",
      price: 200.00,
      offPrice: 10,
      description: 'Non-veg is not always yummy',
      isAvailable: true,
      imgPath: "assets/non-veg.jpg",
      makeDate: Date.now()
    },
  ]


  @Output()
  buy = new EventEmitter()

  handleBuy(event: any) {
    this.buy.emit(event)
  }


  constructor() { }

  ngOnInit(): void {
  }

}
