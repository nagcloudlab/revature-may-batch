import { TODO_FILTERS } from "./todo.filters";
import { Todo } from "./todo.model";


class TodoService {

    todos: Array<Todo> = []

    addTodo(title: string) {
        const newTodo = new Todo(title)
        this.todos = this.todos.concat(newTodo);
        console.log(this.todos);
    }
    editTodo(id: number, newTitle: string) {
        this.todos = this.todos.map((todo: Todo) => {
            if (todo.id === id) {
                todo.title = newTitle;
                return todo;
            } else {
                return todo
            }
        })
    }
    completeTodo(id: number) {
        this.todos = this.todos.map(todo => {
            if (todo.id === id) {
                return { ...todo, completed: !todo.completed }
            } else {
                return todo
            }
        })
    }
    deleteTodo(id: number) {
        this.todos = this.todos.filter(todo => todo.id !== id)
    }
    completeAll() {
        let areAllCompleted = this.todos.every(todo => todo.completed)
        this.todos = this.todos.map(todo => {
            return { ...todo, completed: !areAllCompleted }
        })
    }
    clearCompleted() {
        this.todos = this.todos.filter(todo => !todo.completed)
    }
    getTodos(filter: any) {
        return this.todos
            .filter(TODO_FILTERS[filter]);
    }

}

export { TodoService }
