import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ErsRequestService} from "../ers-request.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-ers-request-form',
  templateUrl: './ers-request-form.component.html',
  styleUrls: ['./ers-request-form.component.css']
})
export class ErsRequestFormComponent implements OnInit {

  requestForm!:FormGroup

  constructor(
    private fb:FormBuilder,
    private router:Router,
    private ersRequestService:ErsRequestService
  ) { }

  ngOnInit(): void {
    this.requestForm = this.fb.group({
      type:[''],
      amount:['0',[Validators.required]]
    })
  }

  handleSubmit(event:Event){
    if(this.requestForm.valid){
      this.ersRequestService.submitNewRequest(this.requestForm.value)
        .subscribe({
          next:()=>{
            this.router.navigate(['ers/view'])
          }}
        )
    }
  }

}
