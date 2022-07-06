//---------------------------------------
// using DOM api
//---------------------------------------

const box = document.querySelector(".alert");
const showBtn = document.querySelector(".btn-success");
const hideBtn = document.querySelector(".btn-danger");
const timeBtn = document.querySelector(".btn-dark");

hideBtn.addEventListener("click", (e) => {
  box.style.display = "none";
});
showBtn.addEventListener("click", (e) => {
  box.style.display = "block";
});
timeBtn.addEventListener("click", (e) => {
  box.innerText = new Date().toLocaleTimeString("en-US", {
    timeZone: "America/New_york",
  });
});

//---------------------------------------
// using DOM api + Timer Api
//---------------------------------------

const timeSpan = document.getElementById("time-span");

setInterval(() => {
  timeSpan.innerText = new Date().toLocaleTimeString("en-US", {
    timeZone: "America/New_york",
  });
}, 1000);

const images = ["images/1.jpeg", "images/2.jpeg", "images/3.jpeg"];

const imgEle = document.getElementById("pov-img");

const startBtn = document.getElementById("start");
const stopBtn = document.getElementById("stop");

stopBtn.disabled = true;
startBtn.addEventListener("click", (e) => {
  stopBtn.disabled = false;
  startBtn.disabled = true;
  let i = 0;
  const intervalId = setInterval(() => {
    const imagePath = images[i];
    imgEle.src = imagePath;
    i++;
    if (i === images.length) {
      i = 0;
    }
  }, 1000);
  stopBtn.addEventListener("click", (e) => {
    clearInterval(intervalId);
    stopBtn.disabled = true;
    startBtn.disabled = false;
  });
});

//---------------------------------------
// using DOM api + XHR ( XML HTTP Request ) Api
//---------------------------------------

const topFiveTodosBtn = document.getElementById("top-five-todos");
const todoListEle = document.getElementById("todo-list");

topFiveTodosBtn.addEventListener("click", (e) => {
  const url = "https://jsonplaceholder.typicode.com/todos?_limit=5";
  // send http request to server

  const xhr = new XMLHttpRequest();
  xhr.open("GET", url, false);
  xhr.send();
  const jsonText = xhr.responseText;
  const todos = JSON.parse(jsonText);
  const liElements = todos.map((todo) => {
    return `
        <li class="list-group-item d-flex justify-content-between ${
          todo.completed ? "bg-success" : ""
        }">
            <span>${todo.id}</span>
            <span>${todo.title}</span>
            <span>${todo.completed}</span>
        </li>
      `;
  });

  todoListEle.innerHTML = liElements.join(" ");
});
