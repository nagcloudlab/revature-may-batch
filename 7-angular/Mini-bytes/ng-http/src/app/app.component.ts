import {Component} from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {TodosService} from './todos.service';
import {
  debounceTime
} from 'rxjs/operators'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'ng-http';
  todos: Array<any> = []

  fg!: FormGroup

  constructor(
    private todosService: TodosService,
    private fb: FormBuilder
  ) {
  }

  ngOnInit() {

    this.fg = this.fb.group({
      limit: ['0']
    })

    // const limitFormControl = this.fg.controls['limit'];
    // limitFormControl
    //   .valueChanges
    //   .pipe(debounceTime(2000))
    //   .subscribe({
    //     next: value => {
    //       this.loadTodos(value)
    //     }
    //   })

    // this.loadTodos(0)
    this.todosService.getTodos()
    this.todosService.todosSteams.subscribe({
      next: todos => {
        this.todos = todos
      }
    })

  }


  // handleTopFiveTodos() {
  //   this.loadTodos(5)
  // }

  // handleLimitChange(event: any) {
  //   let limit = event.target.value
  //   if (limit)
  //     this.loadTodos(limit)
  // }

  // loadTodos(limit: number) {
  //   this.todosService.getTodos(limit)
  //     .subscribe({
  //       next: (response: any) => {
  //         this.todos = response
  //       },
  //       error: (err: any) => {
  //         console.log(err)
  //       }
  //     })
  // }

}
