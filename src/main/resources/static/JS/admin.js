const button = document.querySelector("#submit-button");
const name = document.querySelector("#fullName");
const role = document.querySelector("#role");
const age = document.querySelector("#age");
const email = document.querySelector("#email");
const password = document.querySelector("#password");
const confirmPassword = document.querySelector("#confirm-password");
button.addEventListener("click", function (event) {
    event.preventDefault();
    if (
      name.value == "" ||
      email.value == "" ||
      age.value == null ||
      password.value == "" ||
      password.value !== confirmPassword.value
    ) {
      error.style.display = "block";
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
        password: password.email,
        role: role.value,
        active:"true"
        })
    })
    .then((response)=>console.log(response))
    .catch((error)=>console.log(error))
}