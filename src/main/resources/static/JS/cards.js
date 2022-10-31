cards = document.createElement("template");
cards.innerHTML = `
<style>
.list-items{
    list-style:none;
    display:flex;
    gap:20px;
}
</style>
<ul class="columns is-multiline" id="list-items" >
</ul>
`;
count = 1;
var Cart = [];

function addToCart(itemsid, itemsname, options) {
  var Items = {};
  Items.id = itemsid;
  Items.name = itemsname;
  Items.quantity = count;
  let res = Cart.findIndex((item) => item.id === itemsid);
  if (res === -1 && options === "add") {
    Cart.push(Items);
  } else if (res === -1 && options === "sub") {
    return;
  } else if (options === "add") {
    Cart[res].quantity += 1;
  } else {
    Cart[res].quantity -= 1;
  }
  Cart = Cart.filter((data) => data.quantity != 0);
}

function addItemsToCartList() {
  let x = document.getElementById("cart-list");
  x.textContent = "";
  let li;
  // console.log(Cart)
  if(Cart.length === 0){
    li = document.createElement("li");
    li.innerHTML = `
    <p>There are no elements in the cart</p>
    `
    x.appendChild(li)
  }
  else{
	Cart.forEach((element) => {
      li = document.createElement("li");
      li.innerHTML = `
      
      <span class="icon is-small is-left"> <i
		class="fas fa-envelope"></i>
	  </span>
      <div>
        <p>item: ${element.name}</p>
        <p>quantity: ${element.quantity}</p>
      </div>
      <span class="icon is-small is-left"> <i
		class="fas fa-envelope"></i>
	</span>
	
    `;
      
      x.appendChild(li);
    });
    li = document.createElement("li");
    li.innerHTML = `
    <a class="button is-link" onClick="order()">order</a>
    `
    x.appendChild(li)
  }
}

async function order(){
  console.log(Cart);
  const tableNo = document.getElementById("tableNo").value;
  var response = await fetch("https://java-spring-boot-1098.herokuapp.com/order",{
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },  
    method: "POST",
    body:JSON.stringify({
        tableNo: parseInt(tableNo[tableNo.length -1]),
      })
  })
  let orderid = await response.json();
  // .then((response)=>response.json())
  // .then((data)=>{
  //  
  // Cart.forEach((element)=>{
  //   
  // 
//  let x = document.getElementById("cart-list");
  addItemsToOrder(orderid);
  window.alert("Order Added!")
}

 function addItemsToOrder(orderid){
  Cart.forEach((element)=>{
	  (async () => {
		  const res = await fetch(`https://java-spring-boot-1098.herokuapp.com/orderedItems/${orderid}/${element.id}/${element.quantity}`,{
			    headers: {
				      'Accept': 'application/json',
				      'Content-Type': 'application/json'
				    },  
				    method: "POST",
			});
		  const json = await res.json();
		  console.log(json);
		  console.log("Hello!");
		})();
		  })
}
  
async function postOrderedItems(orderid, elementId, elementQuantity){
	var res=await fetch(`https://java-spring-boot-1098.herokuapp.com/orderedItems/${orderid}/${elementId}/${elementQuantity}`,{
	    headers: {
	      'Accept': 'application/json',
	      'Content-Type': 'application/json'
	    },  
	    method: "POST",
})
	console.log(res);
	}
function callCustomer(orderid){
  document.getElementById("customer-form").innerHTML=`
  <new-customer orderid=${orderid}></new-customer>
  `
}
function displayCart() {
  // console.log(Cart)
  let x = document.getElementById("cart-card");
  if (x.style.display === "block") {
    x.style.display = "none";
  } else {
    x.style.display = "block";
    addItemsToCartList();
  }
}

class Cards extends HTMLElement {
  connectedCallback() {
    this.attachShadow({ mode: "open" });
    this.shadowRoot.innerHTML = `
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
	    `;
    this.shadowRoot.appendChild(cards.content.cloneNode(true));
    fetch("https://java-spring-boot-1098.herokuapp.com/items")
      .then((response) => response.json())
      .then((data) => {
        data.forEach((data) => {
          var li = document.createElement("li");
          li.innerHTML = `
          <div class="column">
            <div class="card" style="width:250px;height:250px">
                <div class="card-content">
                  <h4 class="title is-4">${data.name}</h4>
                  <p class="subtitle is 6">${data.description}</p>
                  <a onClick="addToCart(${data.itemsid},'${data.name}','add')" class="button is-link">₹${data.price}</a>
                  <a onClick="addToCart(${data.itemsid},'${data.name}','sub')" class="button is-cancel">delete</a>          
                </div>
            </div>
            </div>
            `;
          this.shadowRoot.querySelector("#list-items").appendChild(li);
        });
      })
      .catch((error) => console.log(error));
  }
}

window.customElements.define("my-cards", Cards);
