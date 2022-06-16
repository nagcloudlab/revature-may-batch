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

let i = 0;
setInterval(() => {
  const imagePath = images[i];
  imgEle.src = imagePath;
  i++;
  if (i === images.length) {
    i = 0;
  }
}, 1000);
