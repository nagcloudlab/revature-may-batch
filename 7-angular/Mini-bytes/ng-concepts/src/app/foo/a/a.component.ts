import { Component, OnInit } from '@angular/core';
import {FooService} from "../foo.service";

@Component({
  selector: 'foo-a',
  templateUrl: './a.component.html',
  styleUrls: ['./a.component.css'],
  // providers:[
  //   FooService
  // ]
})
export class AComponent implements OnInit {

  constructor(
    private fooService: FooService,
  ){}

  ngOnInit() {
    console.log(this.fooService.getFoo())
  }


}
