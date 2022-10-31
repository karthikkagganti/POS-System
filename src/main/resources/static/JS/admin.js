const button = document.querySelector("#submit-button");
const name = document.querySelector("#fullName");
const role = document.querySelector("#role");
const age = document.querySelector("#age");
const email = document.querySelector("#email");
const password = document.querySelector("#password");
const confirmPassword = document.querySelector("#confirm-password");
const error = document.getElementById("error");
var err= []


button.addEventListener("click", function (event) {
    event.preventDefault();
    if (name.value === "") {
        err.push("The username is missing!");
      }
    if (email.value == "" || !email.value.includes("@")|| !email.value.includes(".")) {
        err.push("The email is missing or incorrect!");
      }
    if (age.value == "") {
        err.push("The age is missing!");
      }
      if (password.value === "") {
        err.push("The password is missing!");
        
      }
      if (password.value !== confirmPassword.value) {
      	console.log(confirmPassword.value)
          err.push("The passwords are not matching!");
        }
      
    
    console.log(err)
    if (err.length !== 0) {
    error.textContent = ''
      error.style.display = "block";
      err.forEach((errors)=>{
    	  const li = document.createElement("li");
    	  li.innerHTML=`
    	  <p>${errors}</p>
    	  `
    	  error.appendChild(li)
      })
      err=[]
      
    } else {
      error.style.display = "none";
      addStaff()
    }
  });
function addStaff(){
    fetch("https://java-spring-boot-1098.herokuapp.com/users",{
        method:"POST",
        headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
          },
        body: JSON.stringify({
        name: name.value,
        age: age.value,
        email: email.value,
        password: password.value,
        role: role.value,
        active:"true"
        })
    })
    .then((response)=>done())
    .catch((error)=>console.log(error))
}

function done(){
	alert("Employee Added!")
	name.value ='';
	password.value ='';
	age.value ='';
	email.value='';
	role.value = '';
}