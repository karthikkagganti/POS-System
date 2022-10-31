const viewCustomers = document.getElementById("view-customers");

fetch("/cust")
  .then((data) => data.json())
  .then((res) => viewCustomers(res));

function viewCustomers(res) {
  let x = document.getElementById("item-list");
  x.textContent = ``;
  items.forEach((element) => {
    li = document.createElement("li");
    li.innerHTML = `
    <div class="column">
      <div class="card" style="width:200px;height:250px">
        <div class="card-content">
            <div class="media-content">
                <p class="title is-4">${element.name}</p>
                <p class="subtitle is-6">Email: ${element.email}</p>
                <p class="subtitle is-6">${element.gender}</p>
                <p class="subtitle is-6">Mobile Number: ${element.mobile}</p>
                <p class="subtitle is-6">Order Date: ${element.orderDate}</p>
                <p class="subtitle is-6">Feedback: ${element.feedback}</p>
                
            </div>
        </div>
      </div>
    </div>
    `;
    x.appendChild(li);
  });
}
