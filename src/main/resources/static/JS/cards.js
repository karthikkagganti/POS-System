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
      <div>
        <p>item: ${element.name}</p>
        <p>quantity: ${element.quantity}</p>
      </div>
    `;
      
      x.appendChild(li);
    });
    li = document.createElement("li");
    li.innerHTML = `
    <button onClick="order()">order</button>
    `
    x.appendChild(li)
  }
}

async function order(){
  console.log(Cart);
  var response = await fetch("https://java-spring-boot-1098.herokuapp.com/order",{
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },  
    method: "POST",
  })
  let orderid = await response.json();
  // .then((response)=>response.json())
  // .then((data)=>{
  //  
  // Cart.forEach((element)=>{
  //   
  // 
  addItemsToOrder(orderid);
}
function addItemsToOrder(orderid){
  Cart.forEach((element)=>{
    fetch(`https://java-spring-boot-1098.herokuapp.com/${orderid}/${element.id}/${element.quantity}`,{
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },  
    method: "POST",
  })
  .then((response)=>console.log(response))
  })
  }


function callCustomer(orderid){
  document.getElementById("customer-form").innerHTML=`
  <new-customer orderid=${orderid}></new-customer>
  `
}
function displayCart() {
  // console.log(Cart)
  let x = document.getElementById("cart-list");
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
            <div class="column card" style="width:300px">
                <div class="card-content">
                  <h4 class="title is-4">${data.name}</h4>
                  <p class="subtitle is 6">${data.description}</p>
                  <a onClick="addToCart(${data.itemsid},'${data.name}','add')" class="button is-link">₹${data.price}</a>
                  <a onClick="addToCart(${data.itemsid},'${data.name}','sub')" class="button is-cancel">delete</a>          
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
