<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css" />
<title>Restaurant Billing System - Menu</title>
<style>
body {
	margin-left: 20px;
	margin-right: 20px;
}

#item-addition {
	display: none;
}

#error {
	display: none;
}

#edit-error {
	display: none;
}

#item-editing {
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
		<div id="item-content">
			<ul id="item-list" class="columns is-multiline"></ul>
			<span class="icon is-small is-left"> <i
				class="fas fa-envelope"></i>
			</span>
			<div class="control">
				<a id="add-items" class="button is-dark">Add New Items</a>
			</div>
		</div>
	</div>
	<div id="item-addition">
		<div class="columns is-mobile">
			<div class="column is-half is-offset-one-quarter">
				<form class="is-centered">
					<p class="title">Items</p>

					<div class="field">
						<label class="label">Name</label>
						<div class="control">
							<input class="input" id="name" type="text"
								placeholder="Please Enter Expense Name" /> <span
								class="icon is-small is-left"> <i class="fas fa-envelope"></i>
							</span>
						</div>
					</div>
					<div class="field">
						<label class="label">Description</label>
						<div class="control">
							<input class="input" id="description" type="text"
								placeholder="Please Enter Expense Name" /> <span
								class="icon is-small is-left"> <i class="fas fa-envelope"></i>
							</span>
						</div>
					</div>

					<div class="field">
						<label class="label">Price</label>
						<div class="control">
							<input class="input" id="price" type="number"
								placeholder="Please Enter Price" /> <span
								class="icon is-small is-left"> <i class="fas fa-envelope"></i>
							</span>
						</div>
					</div>

					<div class="field is-grouped">
						<div class="control">
							<button id="submit-button" type="submit" class="button is-link">
								Submit</button>
						</div>
						<div class="control">
							<button id="cancel-button" class="button is-link is-light">
								Cancel</button>
						</div>
					</div>
					<p id="error">Please fill all the values</p>
				</form>
			</div>
		</div>
	</div>

	<div id="item-editing">
		<div class="columns is-mobile">
			<div class="column is-half is-offset-one-quarter">
				<form class="is-centered">
					<p class="title">Edit Items</p>

					<div class="field">
						<label class="label">Name</label>
						<div class="control">
							<input class="input" id="edit-name" type="text"
								placeholder="Please Enter Expense Name" /> <span
								class="icon is-small is-left"> <i class="fas fa-envelope"></i>
							</span>
						</div>
					</div>
					<div class="field">
						<label class="label">Description</label>
						<div class="control">
							<input class="input" id="edit-description" type="text"
								placeholder="Please Enter Expense Name" /> <span
								class="icon is-small is-left"> <i class="fas fa-envelope"></i>
							</span>
						</div>
					</div>

					<div class="field">
						<label class="label">Price</label>
						<div class="control">
							<input class="input" id="edit-price" type="number"
								placeholder="Please Enter Price" /> <span
								class="icon is-small is-left"> <i class="fas fa-envelope"></i>
							</span>
						</div>
					</div>

					<div class="field is-grouped">
						<div class="control">
							<button id="edit-submit" type="submit" class="button is-link">
								Submit</button>
						</div>
						<div class="control">
							<button id="cancel-button" class="button is-link is-light">
								Cancel</button>
						</div>
					</div>
					<p id="edit-error">Please fill all the values</p>
				</form>
			</div>
		</div>
	</div>

	<script src="JS/main.js"></script>
	<script src="JS/items.js"></script>
</body>
</html>
