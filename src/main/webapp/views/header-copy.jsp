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
			<li ><a href="/logout">Logout</a></li>
			<li><span sec:authentication="username">Username</span></li>
		</ul>
	<div>
</div> 