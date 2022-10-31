<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Customers</title>
</head>
<body>
    <jsp:include page="header.jsp" />
    <div class="ml-4">
        <table class="table">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Order Date</th>
                    <th>Gender</th>
                    <th>Mobile Number</th>
                    <th>Feedback</th>
                </tr>
            </thead>
            <tfoot>
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Order Date</th>
                    <th>Gender</th>
                    <th>Mobile Number</th>
                    <th>Feedback</th>
                </tr>
            </tfoot>
            <tbody id="view-customers">

            </tbody>
        </table>
    </div>
    <script src="JS/viewCustomers.js"></script>
</body>
</html>