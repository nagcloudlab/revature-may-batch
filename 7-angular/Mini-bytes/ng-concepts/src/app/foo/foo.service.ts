import { Injectable } from '@angular/core';

@Injectable()
export class FooService {

  constructor() { }

  getFoo(){
    return "Foo"
  }

}
