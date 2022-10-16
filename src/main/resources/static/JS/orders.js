function changeStatus(id) {
  let a = document.getElementById(id);
  a.remove();
  fetch(`https://java-spring-boot-1098.herokuapp.com/orderedItems/${id}`,{
    method:"PUT",
    headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
  })
}
function displayOrders(orders){
    let x = document.getElementById("order-list");
    console.log(orders);
    orders.forEach((element) => {
        let li = document.createElement("li");
        li.setAttribute("id",element.id)
        li.innerHTML = `
          <div class="column card" style="width:200px">
              <div class="card-content">
                  <div class="media-content">
                      <p class="title is-4">${element.itemName}</p>
                      <p class="subtitle is-6">quantity: ${element.quantity}</p>
                      <a onclick="changeStatus(${element.id})" class="button is-link">Done</a>
                  </div>
              </div>
          </div>
          `;
        x.appendChild(li);
      });
}
let orders = [];
class Orders extends HTMLElement {
  async connectedCallback() {
    this.attachShadow({ mode: "open" });
    this.shadowRoot.innerHTML = `
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
	    `;
   
    let response = await fetch("https://java-spring-boot-1098.herokuapp.com/orderedItems")
    orders = await response.json();
    orders = orders.filter((data) => data.status !== "Done");
    console.log(orders)
    displayOrders(orders);
  }
}

window.customElements.define("new-orders", Orders);
