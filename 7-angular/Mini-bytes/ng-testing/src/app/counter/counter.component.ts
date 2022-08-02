import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-counter',
  templateUrl: './counter.component.html',
  styleUrls: ['./counter.component.css']
})
export class CounterComponent implements OnInit {

  constructor() {
  }

  ngOnInit(): void {
  }

  count: number = 0

  handleCount(val: number) {
    this.count += val;
  }

}
