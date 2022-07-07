

class Todo {
    static nextId = 0;
    constructor(title) {
        Todo.nextId++
        this.id = Todo.nextId
        this.title = title
        this.completed = false
    }
}


export default Todo