import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {ItemService} from '../item.service';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.scss']
})
export class ItemListComponent implements OnInit {


  items: any = []

  //
  //
  // @Output()
  // buy = new EventEmitter()
  //
  // handleBuy(event: any) {
  //   this.buy.emit(event)
  // }


  constructor(private itemService: ItemService) {
  }

  ngOnInit(): void {
    this.itemService.getItems()
      .subscribe({
        next: (response: any) => {
          this.items = response
        }
      })
  }

}
