import {Component, OnInit} from '@angular/core';
import {FooService} from "../foo.service";

@Component({
  selector: 'app-alert',
  templateUrl: './alert.component.html',
  styleUrls: ['./alert.component.css']
})
export class AlertComponent implements OnInit {


  message: string = ""
  type: string = ''

  constructor(private fooService: FooService) {
  }

  ngOnInit(): void {
    this.fooService.alert
      .subscribe({
        next: (alert: any) => {
          this.message = alert.message;
          this.type = alert.type;
          setTimeout(() => {
            this.message = ''
            this.type = ''
          }, 3000)
        }
      })
  }

}
