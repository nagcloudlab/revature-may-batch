import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {BehaviorSubject} from "rxjs";
import {tap} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class TodosService {

  apiUrl: string="http://localhost:8181/api/todos"

  todos:Array<any>=[]
  todosSteams=new BehaviorSubject<any>([])

  constructor(
    private httpClient:HttpClient
  ) { }

  getTodos(limit:number=0){
    this.httpClient.get(`${this.apiUrl}?_limit=${limit}`)
      .subscribe({
        next:(response:any)=>{
          this.todos=response
          this.todosSteams.next(this.todos)
        }
      })
  }

  postNewTodo(newTodo:any){
    return this.httpClient.post(this.apiUrl,newTodo)
      .pipe(tap(response => {
        this.todos.push(response)
        this.todosSteams.next(this.todos)
      }))
  }

}
