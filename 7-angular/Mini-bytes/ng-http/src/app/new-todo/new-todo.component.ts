import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {TodosService} from "../todos.service";

@Component({
  selector: 'app-new-todo',
  templateUrl: './new-todo.component.html',
  styleUrls: ['./new-todo.component.css']
})
export class NewTodoComponent implements OnInit {


  todoForm!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private todosService: TodosService
  ) {
  }

  ngOnInit(): void {
    this.todoForm = this.fb.group({
      title: ['', [Validators.required]],
      type: ['OFFICE']
    })
  }

  handleSubmit(event:Event) {
    if (this.todoForm.valid) {
      this.todosService.postNewTodo(this.todoForm.value)
        .subscribe({
          next: (response: any) => {
            this.todoForm.reset({
              title:'',
              type:'OFFICE'
            })
          }
        })
    }
  }

}
