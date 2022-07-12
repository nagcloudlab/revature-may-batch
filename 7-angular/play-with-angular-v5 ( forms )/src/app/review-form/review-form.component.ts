import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ItemService} from '../item.service';

@Component({
  selector: 'app-review-form',
  templateUrl: './review-form.component.html',
  styleUrls: ['./review-form.component.scss']
})
export class ReviewFormComponent implements OnInit {

  @Output() save = new EventEmitter();

  isFormOpen = false;
  reviewForm!: FormGroup

  constructor(
    private fb: FormBuilder,
  ) {
  }

  ngOnInit(): void {
    this.reviewForm = this.fb.group({
      stars: [3],
      body: ['', Validators.required],
      who: ['Nag']
    })
  }

  toggle() {
    this.isFormOpen = !this.isFormOpen;
  }

  handleSubmit() {
    if (this.reviewForm.valid) {
      let formModel = this.reviewForm.value
      this.save.emit(formModel)
      this.reviewForm.reset({
        stars:1,
        body: '',
        who:'Nag'
      })
      this.toggle()
    }
  }

}
