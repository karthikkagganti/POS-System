<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css" />
<meta charset="UTF-8">
<title>Restaurant Billing System - Home</title>
</head>
<body>

	<jsp:include page="header.jsp" />
	<span class="icon is-small is-left"> <i class="fas fa-envelope"></i>
	</span>
	<div class="ml-4">
		<h1 class="title">Welcome To The Cafe</h1>
		<span class="icon is-small is-left"> <i class="fas fa-envelope"></i>
		</span>
		<div class="field">
			<label class="label is-size-6">Select Table No</label>
			<div class="control">
				<div class="select">
					<select id="tableNo">
						<option>Table 1</option>
						<option>Table 2</option>
						<option>Table 3</option>
						<option>Table 4</option>
					</select>
				</div>
			</div>
		</div>
		<span class="icon is-small is-left"> <i class="fas fa-envelope"></i>
		</span>
		<!-- calling from cards.js -->
		<div>
			<a onClick="displayCart()" class="button is-link">Cart</a>
			<span class="icon is-small is-left"> <i
				class="fas fa-envelope"></i>
			</span>
			<div class="card" id="cart-card" style="display:none;width:250px">
				<div class="card-content">
					<ul id="cart-list"></ul>
				</div>
			</div>
			<span class="icon is-small is-left"> <i
				class="fas fa-envelope"></i>
			</span>
			<div id="customer-form"></div>
			<my-cards></my-cards>
		</div>
		<script src="/JS/cards.js"></script>

	</div>



</body>
</html>