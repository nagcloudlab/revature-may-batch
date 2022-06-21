


const loginForm=document.getElementById("login-form");
const userNameField=document.getElementById("username");
const passwordField=document.getElementById("password");

loginForm.addEventListener("submit",e=>{
    let userName=userNameField.value;
    let password=passwordField.value;
    if(userName==="" || password===""){
        alert("username or password cannot be empty")
        e.preventDefault() // prevent submitting form
    }
    return true
})