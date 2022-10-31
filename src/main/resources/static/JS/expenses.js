const button = document.querySelector("#submit-button");
const name = document.querySelector("#name");
const amount = document.querySelector("#amount");
const success = document.querySelector("#success");

button.addEventListener("click", function (event) {
    event.preventDefault();
    if (
      name.value == "" ||
      amount.value == 0
    ) {
      error.style.display = "block";
    } else {
      error.style.display = "none";
      addExp()
    }
  });
function addExp(){
	
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
    .then((res)=>done())
    .catch((err)=>console.log(err))
}

function done(){
	success.style.display="block";
	name.value ='';
	amount.value =''
}