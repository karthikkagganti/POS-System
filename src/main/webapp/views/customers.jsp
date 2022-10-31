<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
    <title>Restaurant Billing System - FeedBack</title>
    <style>
        body{
            margin-left:20px;
        }
    </style>
</head>
<body>
    
    <jsp:include page="header.jsp"/>
    <h3 class="ml-4">Add Customers from here!</h3>
    <new-customer></new-customer>
    <script th:src="@{/JS/main.js}"></script>
    <script src="/JS/customer.js"></script>
    
</body>
</html>