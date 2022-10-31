const count =1;

fetch("/cust")
  .then((data) => data.json())
  .then((res) => view_customers(res));

function view_customers(res) {
  let x = document.getElementById("view-customers");
  x.textContent = ``;
  res.forEach((element) => {
    const tableRow = document.createElement("tr");
    
    tableRow.innerHTML = `
				<td>${count}</td>
				<td>${element.name}</td>
				<td>${element.email}</td>
				<td>${element.mobile}</td>
				<td>${element.orderDate}</td>
				<td>${element.feedback}</td>
                `;
    x.appendChild(li);
    count++;
  });
}
