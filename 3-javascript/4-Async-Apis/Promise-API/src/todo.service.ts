import axios from 'axios' // HTTP client lib , promise  api based

//------------------------------------------
// Service module (NON-UI logic) e.g n/w calls
//------------------------------------------
export function loadTodos(limit = 5) {

    const url = `https://jsonplaceholder.typicode.com/todos?_limit=${limit}`

    // ------------------------------------------------------
    // way-1 : XHR API
    // ------------------------------------------------------

    /*

    const promise = new Promise((resolve, reject) => {
        const xhr = new XMLHttpRequest(); // browser api to send async http calls
        xhr.open('GET', url, true)
        xhr.send();

        xhr.onreadystatechange = function () {
            if (xhr.status === 200 && xhr.readyState === 4) {
                const jsonText = xhr.responseText;
                const todos = JSON.parse(jsonText);
                resolve(todos)
            }
        }
    });
    return promise;

    */


    // or

    return axios.get(url)
        .then(response => response.data);


    // ------------------------------------------------------
    // way2 : Fetch API - https://www.w3schools.com/js/js_api_fetch.asp
    // ------------------------------------------------------

    // return fetch(url)
    //     .then(response => response.json());




}