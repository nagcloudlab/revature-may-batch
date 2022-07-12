import {Component, OnInit} from '@angular/core';
import {CounterService} from "../counter.service";

@Component({
  selector: 'app-tom',
  templateUrl: './tom.component.html',
  styleUrls: ['./tom.component.css']
})
export class TomComponent implements OnInit {

  count=0;
  //
  // increment(){
  //   this.count++;
  // }

  handleEvent() {
    this.counterService.increment()
  }

  // DI
  constructor(private counterService: CounterService) {
  }

  ngOnInit(): void {
    this.counterService.counterStream.subscribe({
      next:data=>{
        this.count=data.count
      }
    })
  }

}
