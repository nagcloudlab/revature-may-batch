import { Component, OnInit } from '@angular/core';

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
      description: 'Veg is always yummy',
      isAvailable: true,
      imgPath: "assets/veg.png"
    },
    {
      name: "Non-VEG",
      price: 200.00,
      description: 'Non-veg is not always yummy',
      isAvailable: false,
      imgPath: "assets/non-veg.jpg"
    },
  ]


  constructor() { }

  ngOnInit(): void {
  }

}
