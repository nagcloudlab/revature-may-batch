import {Component} from '@angular/core';
import {FooService} from './foo.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ng-observable';

  todos: Array<any> = []

  constructor(private fooService: FooService) {
  }

  ngOnInit() {
    this.fooService.todos
      .subscribe({
        next: (todos: any) => {
          this.todos = todos
        }
      })
  }

  handleLoadTodos() {
    this.fooService.loadTodos()
  }


}
