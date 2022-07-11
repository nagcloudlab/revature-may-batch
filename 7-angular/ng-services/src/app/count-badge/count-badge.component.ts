import { Component, OnInit } from '@angular/core';
import { CounterService } from '../counter.service';

@Component({
  selector: 'app-count-badge',
  templateUrl: './count-badge.component.html',
  styleUrls: ['./count-badge.component.css']
})
export class CountBadgeComponent implements OnInit {


  value=0;

  constructor(private counterService: CounterService) { }

  // Life-cycle method
  ngOnInit(): void {
    // why we need ?  to do any one-time init on comp
    this.counterService.counterStream.subscribe({
      next:data=>{
        this.value=data.count
      }
    })
  }

}
