const tableNo = document.getElementById("billing-table-options");
let orders = [];

function changeStatus(id) {
  let a = document.getElementById("li-"+id);
  a.remove();
  fetch(`https://java-spring-boot-1098.herokuapp.com/order/${id}`,{
    method:"PUT",
    headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
  })
}
function displayOrders(orders){
    let x = document.getElementById("order-list");
    x.textContent =''
    console.log(orders);
    orders.forEach((order) => {
        let li = document.createElement("li");
        li.setAttribute("id","li-"+order.orderid)
        li.innerHTML = `
        <div class="column">
          <div class="column card" style="width:200px; gap:10px">
              <div class="card-content">
                  <div id="${order.orderid}" class="media-content">
                      <p class="title is-4">Table No: ${order.tableNo}</p>
                      
                  </div>
              </div>
              <a onclick="changeStatus(${order.orderid})" class="button is-link ml-6">Done</a>
            </div>
           </div>
          `;
        x.appendChild(li);
        order.orders.forEach((element) => {
            p = document.createElement("div");
            p.innerHTML = `<p>${element.quantity}   X  ${element.itemName}</p>
            <span class="icon is-small is-left">
            <i class="fas fa-envelope"></i>
            </span>
            `
            document.getElementById(order.orderid).append(p)
        })
    });
}

function selectBillingTableNo(){
	if(tableNo.value === "Select All Tables"){	
		displayOrders(orders);
		return
	}
	console.log("here")
//	console.log(parseInt(tableNo.value))
	orders.forEach((data)=> console.log(data.tableNo))
	console.log(orders)
	const modifiedOrder = orders.filter((data)=> data.tableNo === parseInt(tableNo.value))
	console.log(modifiedOrder)
	displayOrders(modifiedOrder);
}


class Orders extends HTMLElement {
  async connectedCallback() {
    this.attachShadow({ mode: "open" });
    this.shadowRoot.innerHTML = `
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
	    `;
   
    let response = await fetch("https://java-spring-boot-1098.herokuapp.com/order")
    orders = await response.json();
// orders = orders.filter((data) => data.status !== "Done");
    displayOrders(orders);
  }
}

window.customElements.define("new-orders", Orders);
