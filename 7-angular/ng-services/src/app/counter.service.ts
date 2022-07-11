import { Injectable } from '@angular/core';
import { Subject,BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CounterService {

  count=0;

  // countStream=new Subject()
  counterStream=new BehaviorSubject({count:0});

  constructor() {
    console.log("CounterService instantiated")
  }

  increment(){
    this.count++;
    this.counterStream.next({count:this.count})
  }


}
