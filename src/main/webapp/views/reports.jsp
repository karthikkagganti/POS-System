<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css" />
<title>Restaurant Billing System - Reports</title>
<style>
body {
	margin-left: 20px;
}

#view-area {
	display: none;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="ml-4">
		<h3>Hey Owner!</h3>
		<span class="icon is-small is-left"> <i class="fas fa-envelope"></i>
		</span>
		<div id="report-content">
			<ul id="report-list" class="columns is-multiline"></ul>
			<span class="icon is-small is-left"> <i
				class="fas fa-envelope"></i>
			</span>
		</div>
		<div class="control">
			<a id="generate-report" class="button is-dark">Generate Report</a>
		</div>
		<span class="icon is-small is-left"> <i class="fas fa-envelope"></i>
		</span>
		<div id="view-area">
			<p class="title is-4">Here are the contents of the daily report</p>
			<p class="title is-3" id="reportDate"></p>
			<p class="subtitle is-5" id="report-subtitle"></p>
			<p class="subtitle is-5" id="sales"></p>
			<p subtitle is-5>Here are the expenses:</p>
			<span class="icon is-small is-left"> <i
				class="fas fa-envelope"></i>
			</span>
			<ul id="expense-list" class="cards columns is-multiline">

			</ul>
			<span class="icon is-small is-left"> <i
				class="fas fa-envelope"></i>
			</span>
			<p subtitle is-5>Here are the orders:</p>
			<span class="icon is-small is-left"> <i
				class="fas fa-envelope"></i>
			</span>
			<ul id="order-list" class="cards columns is-multiline">

			</ul>
			<span class="icon is-small is-left"> <i
				class="fas fa-envelope"></i>
			</span>
			<button onclick="closeWindow()" class="button is-light">close</button>
			<span class="icon is-small is-left"> <i
				class="fas fa-envelope"></i>
			</span>
			<div></div>
		</div>
	</div>
	<script src="JS/report.js"></script>
</body>
</html>
