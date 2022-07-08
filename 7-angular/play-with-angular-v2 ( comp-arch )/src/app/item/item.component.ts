import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.scss']
})
export class ItemComponent implements OnInit {


  @Input("value")
  item: any = {}

  currentTab = 1

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
