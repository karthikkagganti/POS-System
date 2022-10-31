const viewCustomers = document.getElementById("view-customers");


fetch("/cust")
.then((data)=>data.json())
.then((res)=>console.log(res))