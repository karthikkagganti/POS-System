const button = document.querySelector("#submit-button");
const name = document.querySelector("#name");
const amount = document.querySelector("#amount");
button.addEventListener("click", function (event) {
    event.preventDefault();
    if (
      name.value == "" ||
      amount.value == 0
    ) {
      error.style.display = "block";
    } else {
      error.style.display = "none";
      addStaff()
    }
  });
function addStaff(){
    fetch("https://java-spring-boot-1098.herokuapp.com/expenses",{
        method:"POST",
        headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
          },
        body: JSON.stringify({
        name: name.value,
        amount: amount.value,
        })
    })
    .then((response)=>console.log(response))
    .catch((error)=>console.log(error))
}