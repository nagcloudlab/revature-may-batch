import './index.scss'
import { Todo } from './todo.model'

import { TodoService } from './todo.service'


const todoService = new TodoService()
// todoService.addTodo("todo-1")
// todoService.addTodo("todo-2")


//-----------------------------------------------------
// DOM Fields
//-----------------------------------------------------
const newTodoField = document.getElementById("new-todo")
const todoListEle = document.getElementById('todo-list')
//-----------------------------------------------------
// Event Handlers
//-----------------------------------------------------

newTodoField.addEventListener('keyup', (e: KeyboardEvent) => {
    const key = e.key;
    const target = (<HTMLInputElement>e.target)
    const title = target.value;
    if (title === "")
        return
    if (key !== 'Enter')
        return
    todoService.addTodo(title)
    target.value = ""
    renderTodos()
})

// window.addEventListener('click', e => {
//     console.log(e);
// })

todoListEle.addEventListener('click', e => {
    e.stopPropagation();
    const dataset = (<HTMLInputElement>e.target).dataset;
    const action = dataset['action']
    if (action === 'complete') {
        const id = dataset['id'];
        todoService.completeTodo(Number.parseInt(id))
    }
    if (action === 'delete') {
        const id = dataset['id'];
        todoService.deleteTodo(Number.parseInt(id))
    }
    renderTodos()
})


//-------------------------------------------------------
// Render Todos
//-------------------------------------------------------
function renderTodos(filter = 'ALL') {
    let todos = todoService.getTodos(filter)
    const todoListElements = todos.map((todo: Todo) => {
        return `
            <li class="list-group-item d-flex justify-content-between ${todo.completed ? 'bg-warning' : ''}">
                <input data-action="complete" data-id=${todo.id} type="checkbox" ${todo.completed ? 'checked' : ''}/>
                <span>${todo.title}</span>
                <button data-action="delete" data-id=${todo.id} class="btn btn-sm btn-danger">delete</button>
            </li>
        `
    });
    todoListEle.innerHTML = todoListElements.join("")
}
renderTodos();