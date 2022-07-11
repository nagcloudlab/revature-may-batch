import {Component, OnInit} from '@angular/core';
import {CounterService} from "../counter.service";

@Component({
  selector: 'app-jerry',
  templateUrl: './jerry.component.html',
  styleUrls: ['./jerry.component.css']
})
export class JerryComponent implements OnInit {

  count=0;
  //
  // increment(){
  //   this.count++;
  // }

  handleEvent() {
    this.counterService.increment()
  }

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
