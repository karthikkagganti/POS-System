<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width = device-width, initial-scale = 1">
<title>Restaurant Billing System - Billing</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
<style>
#billing-section{
display:none;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp" />
	<span class="icon is-small is-left"> <i class="fas fa-envelope"></i>
	</span>
	<div class="field ml-4">
		<label class="label">Select Table No</label>
		<div class="control">
			<div class="select">
				<select id="billing-table-options" onchange="selectBillingTableNo()">
					<option>Select Table No.</option>
				</select>
			</div>
		</div>
	</div>
	<span class="icon is-small is-left"> <i class="fas fa-envelope"></i>
	</span>
	<section class="section" id="billing-section">
		<div class="container">
			<span class="is-size-3">Cafe Bill </span><br> <span
				class="is-size-5">Bangalore, Karnataka, India </span> <br> <span
				class="is-size-6" id="bill-date">Date:{date} </span><br> <span
				class="is-size-6" id="bill-tableNo">Table No: {tableNo} </span><br>
			<span class="icon is-small is-left"> <i
				class="fas fa-envelope"></i>
			</span>
			<table class="table">
				<thead>
					<tr>
						<th>Sl No.</th>
						<th>Item Name</th>
						<th>Price(inclusive of GST.)</th>
						<th>Quantity</th>
						<th>SubTotal</th>

					</tr>
				</thead>
				<tfoot>
					<tr>
						<th></th>
						<th></th>
						<th></th>
						<th>Total</th>
						<th id="bill-total"></th>
					</tr>
				</tfoot>
				<tbody id="table-body">

				</tbody>
			</table>
			<div class="control">
				<button id="proceed-to-pay" class="button is-link">Proceed
					To Pay</button>
			</div>
		</div>

	</section>

	<script src="/JS/billing.js"></script>
</body>
</html>