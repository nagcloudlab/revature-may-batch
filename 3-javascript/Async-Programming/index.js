


// Using DOM API

const viewTodosBtn = document.getElementById('view-todos-btn')
const todosTable = document.getElementById('todos-table')
const messageSpan = document.getElementById('message-span')


// using XHR or Fetch API

viewTodosBtn.addEventListener('click', e => {

    const apiUrl = "http://localhost:8181/api/todos"


    // XHR Api

    // const xhr = new XMLHttpRequest()
    // xhr.open('GET', apiUrl, true)
    // xhr.send() // sync http request // blocking-call
    // messageSpan.innerText = "loading todos"

    // xhr.onreadystatechange = function () {
    //     if (xhr.readyState === 4) {
    //         messageSpan.innerText = ""
    //         const jsonText = xhr.responseText
    //         const todos = JSON.parse(jsonText)
    //         const rows = todos.map(todo => {
    //             return `
    //                 <tr>
    //                 <td>${todo.id}</td>
    //                 <td>${todo.title}</td>
    //                 <td>${todo.completed}</td>
    //                 <td>${todo.type}</td>
    //                 </tr>
    //             `
    //         })
    //         todosTable.innerHTML = rows.join("");
    //     }
    // }


    // Fetch Api
    const promise = fetch(apiUrl, { method: 'GET' })
    messageSpan.innerText = "loading todos"
    promise
        .then(response => response.json())
        .then(todos => {
            messageSpan.innerText = ""
            const rows = todos.map(todo => {
                return `
                    <tr>
                    <td>${todo.id}</td>
                    <td>${todo.title}</td>
                    <td>${todo.completed}</td>
                    <td>${todo.type}</td>
                    </tr>
                `
            })
            todosTable.innerHTML = rows.join("");
        })

})