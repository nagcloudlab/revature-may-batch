import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AComponent } from './a/a.component';



@NgModule({
  declarations: [
    AComponent
  ],
  imports: [
    CommonModule
  ],
  exports:[
    AComponent
  ],
})
export class BarModule { }
