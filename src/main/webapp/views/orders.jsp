<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
<title>Restaurant Billing System - Orders</title>
<style>
body {
	margin-left: 20px;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp" />
	<span class="icon is-small is-left"> <i class="fas fa-envelope"></i>
	</span>
	<div class="ml-4">
		<h3>Hey Chef!</h3>
		<span class="icon is-small is-left"> <i class="fas fa-envelope"></i>
		</span>
		<h1 class="title">Here are the current orders:</h1>
		<div class="field ">
			<label class="label">Select Table No</label>
			<div class="control">
				<div class="select">
					<select id="billing-table-options"
						onchange="selectBillingTableNo()">
						<option>Select All Tables</option>
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
					</select>
				</div>
			</div>
		</div>

		<span class="icon is-small is-left"> <i class="fas fa-envelope"></i>
		</span>
		<ul id="order-list" class="columns is-multiline"></ul>
		<new-orders></new-orders>
	</div>
	<script src="JS/orders.js"></script>
</body>
</html>
