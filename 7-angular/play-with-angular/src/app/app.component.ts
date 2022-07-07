import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  title = "FTGO"

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

  currentTab = 1

  handleTabChange(event: Event, tabIndex: number) {
    this.currentTab = tabIndex
  }

  isTabSelected(tabIndex: number) {
    return this.currentTab === tabIndex
  }


}
