import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html',
  styleUrls: ['./customer-form.component.css']
})
export class CustomerFormComponent implements OnInit {

  customerForm!: FormGroup

  errors: any = {}

  constructor(
    private fb: FormBuilder
  ) {
  }

  ngOnInit(): void {
    this.customerForm = this.fb.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      mobile: ['', [Validators.required, Validators.pattern("\\d{10}")]]
    })


    let mobileControl = this.customerForm.controls['mobile']
    mobileControl.statusChanges
      .subscribe({
        next: status => {
          console.log(status)
          if (status === 'INVALID') {
            this.errors['mobile'] = "invalid mobile"
            console.log(this.errors)
          } else {
            delete this.errors['mobile']
          }
        }
      })


  }

  handleForm(event: Event) {
    if (this.customerForm.valid) {
      const formData = this.customerForm.value;
      console.log(formData)
    }
  }

  loadCustomer(){
    // get customer details from service if logged-in
    // get making api calls
    let customerData={
      name:"gene",
      email:"gene@mail.com"
    }
    this.customerForm.patchValue(customerData)
  }


}
