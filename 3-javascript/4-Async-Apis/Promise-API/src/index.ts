
import 'todomvc-app-css/index.css';
import { loadTodos } from './todo.service'

//------------------------------------------------
// UI module ( Rendering logic)
//------------------------------------------------
async function renderTodos() {

    /*
   
    const promise = loadTodos(100);
   
    promise
        .then((todos: Array<any>) => {
            let todoListElements = todos.map((todo: any) => {
                return `
                    <li class="${todo.completed ? 'completed' : ''}">
                        <div class="view">
                        <input class="toggle" type="checkbox" ${todo.completed ? 'checked' : ''}>
                        <label>${todo.title}</label>
                        <button class="destroy"></button>
                        </div>
                    </li>
                `
            })
            document.querySelector('.todo-list')
                .innerHTML = todoListElements.join("")
        })
        .catch(error => {
            console.log(error);
        })
        
    */

    // -or-

    try {
        let todos = await loadTodos();
        let todoListElements = todos.map((todo: any) => {
            return `
                <li class="${todo.completed ? 'completed' : ''}">
                    <div class="view">
                    <input class="toggle" type="checkbox" ${todo.completed ? 'checked' : ''}>
                    <label>${todo.title}</label>
                    <button class="destroy"></button>
                    </div>
                </li>
            `
        })
        document.querySelector('.todo-list')
            .innerHTML = todoListElements.join("")
    } catch (error) {
        console.log(error);
    }


}

renderTodos();