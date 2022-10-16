const header=document.createElement('template');
header.innerHTML =`
<style>
#header{
	background-color:#090520;
	border-radius: 15px;
}
#task-list {
	list-style:none;
	display:flex;
	flex-wrap:wrap;
	flex-direction:row;

	gap: 20px;
	font-size:20px;
}
#taskbar{
	display:flex;
	flex-wrap:wrap;
	flex-direction:row;
	justify-content: space-between;
}
#main-head{
	display:flex;
	height:100%;
	margin-top:20px;
	margin-left:20px;
	justify-content:center;
	color:white;
	text-decoration:none;
	font-size:25px;
}
li a{
	color:white;
	text-decoration: none;
}
</style>
<div id="header">
	<div id = "taskbar">
		<a href="/" id="main-head">Restaurant Billing System</a>
		<ul id="task-list">
			<li><a href="/">Home</a></li>
			<li ><a href="/admin">Admin</a></li>
			<li ><a href="/orders">Orders</a></li>
			<li ><a href="/reports">Reports</a></li>
			<li ><a href="/expenses">Expenses</a></li>
			<li ><a href="/item">Items</a></li> 
			<li ><a href="/customer">Customer</a></li> 
		</ul>
	<div>
</div>
`
const footer = document.createElement('template');
footer.innerHTML=`
<style>
h3{
	color : red;
}
</style>
<footer>
	<h3>This is the footer</h3>
</footer>
`



class MyHeader extends HTMLElement {

  constructor() {
	super();
	this.attachShadow({mode:"open"})
	this.shadowRoot.appendChild(header.content.cloneNode(true));
	this.shadowRoot.getElementById(this.getAttribute('hello')).style.display="block";
	
  }
}

window.customElements.define('my-header', MyHeader);

class MyFooter extends HTMLElement {
  constructor() {
	super();
	this.attachShadow({mode:"open"})
	this.shadowRoot.appendChild(footer.content.cloneNode(true));
  }
}

customElements.define("my-footer", MyFooter);
