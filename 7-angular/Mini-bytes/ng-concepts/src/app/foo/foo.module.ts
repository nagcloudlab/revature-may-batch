import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AComponent} from './a/a.component';
import {BComponent} from './b/b.component';
import {CComponent} from './c/c.component';
import {FooService} from "./foo.service";


@NgModule({
  declarations: [
    AComponent,
    BComponent,
    CComponent
  ],
  imports: [
    CommonModule
  ],
  providers: [
    FooService
  ],
  exports: [
    AComponent,
  ],
})
export class FooModule {
}
