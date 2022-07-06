import Todo from '../model/todo'

class TodosService {

    todos = []
    addTodo(title) {
        const p = new Promise((resolve, reject) => {
            let newTodo = { title }
            fetch("http://localhost:8181/api/todos", {
                method: 'POST',
                body: JSON.stringify(newTodo),
                headers: { 'Content-Type': "application/json" }
            })
                .then(response => response.json())
                .then(todo => {
                    console.log(todo)
                    this.todos.unshift(todo)
                    resolve()
                })
        })
        return p;
    }
    deleteTodo(id) {
        let idx = this.todos.findIndex(todo => todo.id === id)
        this.todos.splice(idx, 1)
    }
    completeTodo(id) {
        let todo = this.todos.find(todo => todo.id === id)
        todo.completed = !this.completed
    }
    getTodos() {
        return this.todos
    }
    loadTodos() {
        const p = new Promise((resolve, reject) => {
            fetch("http://localhost:8181/api/todos")
                .then(response => response.json())
                .then(todos => {
                    this.todos = todos.map(t => {
                        let todo = new Todo()
                        todo.id = t.id
                        todo.title = t.title
                        todo.completed = t.completed
                        return todo
                    })
                    resolve()
                })
        })
        return p;
    }
}

export default TodosService 