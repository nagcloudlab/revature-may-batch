import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

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

  reviews = [
    { stars: 5, body: 'sample-review-1', who: 'who1' },
    { stars: 1, body: 'sample-review-2', who: 'who2' }
  ]

  handleBuy() {
    this.buy.emit({ ...this.item })
  }

  handleTabChange(event: Event, tabIndex: number) {
    this.currentTab = tabIndex
  }

  isTabSelected(tabIndex: number) {
    return this.currentTab === tabIndex
  }

  constructor() { }

  ngOnInit(): void {
  }

}
