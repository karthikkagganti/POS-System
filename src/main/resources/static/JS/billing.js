const tbody = document.getElementById("table-body");
const billTotal = document.getElementById("bill-total");
const count = 1;
const billTable = document.getElementById("billing-table-options");
const billTableNo = document.getElementById("bill-tableNo");
const billDate = document.getElementById("bill-date");
const payButton = document.getElementById("proceed-to-pay");



var tables = [];
var set = new Set();

fetchBill();

 function fetchBill(){
	fetch("http://localhost:8000/billings")
	.then((res)=>res.json())
	.then((data)=>addTableNo(data))
}

 function addTableNo(data){
	
	 tables = data;
	 data.forEach((data)=>{
		 set.add(data.tableNo)
	 })
	 set.forEach((data)=>{
		 const options = document.createElement("option")
		 options.innerHTML=(`${data}`)
		 billTable.appendChild(options)
	 })
	 console.log(data)
 }

function selectBillingTableNo(){
	if(billTable.value === "Select Table No."){
		document.getElementById("billing-section").style.display="none";
		return
	}
	document.getElementById("billing-section").style.display="block";
	tbody.textContent = ''
	var total=0;
	billTableNo.innerHTML =`Table No. : ${billTable.value}`
	
	tables.forEach((table)=>{
		if(table.tableNo == billTable.value && table.status === "billing"){
			billDate.innerHTML = `Order Date: ${table.orderDate}`
			
			
			table.orders.forEach((order)=>{
                total += order.subTotal;
                const tableRow = document.createElement("tr");
				tableRow.innerHTML = `
				<td>${count}</td>
				<td>${order.itemName}</td>
				<td>${order.subTotal/order.quantity}</td>
				<td>${order.quantity}</td>
				<td>₹${order.subTotal}</td>
				`
				tbody.appendChild(tableRow)
			})
		}
	})
	
	billTotal.innerHTML = "₹"+ total.toString();
	
}


payButton.addEventListener('click', function (event){
	event.preventDefault();
	if(billTable.value === "Select Table No."){
		return
	}
	window.location = "http://localhost:8000/customer";
})




