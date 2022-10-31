const button = document.querySelector("#submit-button");
const edit = document.querySelector("#edit-submit");
const a = document.querySelector("#add-items");
const name = document.querySelector("#name");
const price = document.querySelector("#price");
const description = document.querySelector("#description");
displayItems();

button.addEventListener("click", function (event) {
  event.preventDefault();
  if (name.value == "" || price.value == 0 || description.value == "") {
    error.style.display = "block";
  } else {
    error.style.display = "none";
    addItem();
    
  }
});

a.addEventListener("click", function (event) {
  event.preventDefault();
  let x = document.getElementById("item-addition");
  let y = document.getElementById("item-editing");
  y.style.display="none"
  if (x.style.display === "block") {
    x.style.display = "none";
  } else {
    x.style.display = "block";
  }
});




function addItem() {
  fetch("http://localhost:8000/items", {
    method: "POST",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      name: name.value,
      description: description.value,
      price: price.value,
    }),
  })
    .then((response) => location.reload())
    .catch((error) => console.log(error));
}

function displayItemsFromArray(items) {
  let x= document.getElementById("item-list")
  x.textContent=``
  items.forEach((element) => {
    li = document.createElement("li");
    li.innerHTML=`
    <div class="column">
      <div class="card" style="width:200px;height:250px">
        <div class="card-content">
            <div class="media-content">
                <p class="title is-4">${element.name}</p>
                <p class="subtitle is-6">${element.description}</p>
                <p class="subtitle is-6">price: ₹${element.price}</p>
                <a onclick="temp(${element.itemsid})" class="button is-link">Edit</a>
            </div>
        </div>
      </div>
    </div>
    `
    x.appendChild(li)
  });
}

async function displayItems() {
  let response = await fetch("http://localhost:8000/items");
  let items = await response.json();
  displayItemsFromArray(items)
  
}

function temp(id){
  console.log(id)
  let y = document.getElementById("item-addition");
  y.style.display="none"
  let x = document.getElementById("item-editing");
  if (x.style.display === "block") {
    x.style.display = "none";
  } else {
    x.style.display = "block";
    editItem(id)
  }
}

function editItem(id){
const edit_name = document.querySelector("#edit-name");
const edit_price = document.querySelector("#edit-price");
const edit_description = document.querySelector("#edit-description");
const edit_error = document.getElementById("edit-error");
edit.addEventListener("click",function(event){
  event.preventDefault();
  if (edit_name.value == "" || edit_price.value == 0 || edit_description.value == "") {
    console.log(edit_error.innerHTML)
    edit_error.style.display = "block";
  } else {
    error.style.display = "none";
    postEditedItem(id, edit_name.value, edit_price.value,edit_description.value)
    location.reload();
  }
})
}

function postEditedItem(id, name, price, description){
  fetch(`http://localhost:8000/items/${id}`,{
    method:"PUT",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      name: name,
      description: description,
      price: price,
    }),
  })
  .then((res)=>location.reload())
}
