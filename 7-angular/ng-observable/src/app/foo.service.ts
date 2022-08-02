import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {BehaviorSubject, Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class FooService {

  baseUril = "https://jsonplaceholder.typicode.com"

  todos = new BehaviorSubject<any>([])
  alert = new BehaviorSubject({message: '', type: ''})

  constructor(
    private httpClient: HttpClient
  ) {
  }

  loadTodos() {
    this.httpClient.get(`${this.baseUril}/todos?_limit=5`)
      .subscribe({
        next: (value: any) => {
          this.todos.next(value)
          this.alert.next({
            message: 'todos loaded',
            type: ''
          })
        },
        error: (err: any) => {
          this.alert.next({
            message: err.message,
            type: 'error'
          })
        },
        complete: () => {
        }
      })
  }

}
