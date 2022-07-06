import 'bootstrap/dist/css/bootstrap.css';

import TodosService from './service/todos-service';


const todosService = new TodosService()
todosService
    .loadTodos()
    .then(() => {
        renderTodos(todosService.getTodos())
    })

// todosService.addTodo('todo-1')
// todosService.addTodo('todo-2')
// todosService.addTodo('todo-3')

// -------------------------------------------
// Using DOM Api
// -------------------------------------------

const todoInpEle = document.getElementById('todo-inp')
const todosTable = document.getElementById('todos-table')

// ----------------------------------------------------------------
// Add todo
// ----------------------------------------------------------------
todoInpEle.addEventListener('keyup', e => {
    if (e.key === "Enter") {
        const title = todoInpEle.value
        if (title) {
            todosService.addTodo(title)
                .then(() => {
                    todoInpEle.value = ""
                    renderTodos(todosService.getTodos())
                })
        }
    }
})
// ----------------------------------------------------------------
// Delete todo
// ----------------------------------------------------------------

todosTable.addEventListener('click', e => {
    let { todoId, action } = e.target.dataset
    if (action === "delete")
        todosService.deleteTodo(Number.parseInt(todoId))
    if (action === "complete")
        todosService.completeTodo(Number.parseInt(todoId))
    renderTodos(todosService.getTodos())
})

// ----------------------------------------------------------------
// Render todos
// ----------------------------------------------------------------
function renderTodos(todos) {
    const rows = todos
        .map(todo => {
            return `
                <tr class="${todo.completed ? 'bg-secondary' : ''}">
                    <td><input  ${todo.completed ? 'checked' : ''} data-todo-id="${todo.id}" data-action="complete" type="checkbox" /></td>
                    <td>${todo.title}</td>
                    <td>${todo.completed ? 'yes' : 'no'}</td>
                    <td><button data-todo-id="${todo.id}"  data-action="delete" class="btn btn-sm btn-danger">delete</button></td>
                </tr>
        `
        })
    todosTable.innerHTML = rows.join("")
}

