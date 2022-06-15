//-----------------------------
// Using DOM Api
//-----------------------------

// step-1 : select/query required DOM elemnts

const alertBox = document.querySelector(".alert");
const greetBtn = document.querySelector(".btn");

// step-2 : bind event Listeners , on even react

greetBtn.addEventListener("click", (e) => {
  alertBox.innerText = "Welcome " + alertBox.innerText;
});
