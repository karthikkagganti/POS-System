<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
.navbar-item.is-mega {
  position: static;

  .is-mega-menu-title {
    margin-bottom: 0;
    padding: .375rem 1rem;
  }
}
</style>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css" />
<body>
<nav class="navbar ">
  <div class="navbar-brand">
    <a class="navbar-item" href="/">
            <span class="is-size-4">Restaurant Billing System</span>

    </a>

    <div class="navbar-burger burger" data-target="navMenubd-example">
      <span></span>
      <span></span>
      <span></span>
    </div>
  </div>

  <div id="navMenubd-example" class="navbar-menu">
    <div class="navbar-end">
       <a href="/" class="navbar-item ishoverable ">
        Home
      </a>
      
      <c:if test="${not empty pageContext.request.userPrincipal}">

    <c:if test="${pageContext.request.isUserInRole('ADMIN')}">
		<a href="/admin" class="navbar-item ">
        Admin
      </a>
    </c:if>
    
     <c:if test="${pageContext.request.isUserInRole('CHEF')}">
		<a href="/orders" class="navbar-item ">
        Orders
      </a>
    </c:if>
    
    <c:if test="${pageContext.request.isUserInRole('CASHIER')}">
		<a href="/customer" class="navbar-item ">
        Customer
      </a>
      <a href="/billing" class="navbar-item ">
        Billing
      </a>
    </c:if>
    
    <c:if test="${pageContext.request.isUserInRole('OWNER')}">
    <a href="/admin" class="navbar-item ">
        Admin
      </a>
      <a href="/customer" class="navbar-item ">
        Customer
      </a>
    <a href="/orders" class="navbar-item ">
        Orders
      </a>
		<a href="/item" class="navbar-item ">
        Menu
      </a>
      <a href="/expenses" class="navbar-item ">
        Expenses
      </a>
      <a href="/reports" class="navbar-item ">
        Reports
      </a>
      <a href="/billing" class="navbar-item ">
        Billing
      </a>
      
    </c:if>
    <a href="/logout" class="navbar-item ">
        Logout
      </a>
</c:if> 
      <a href="/login" class="navbar-item ">
        Login
      </a>

    </div>

  
      </div>

</nav>

<script src="JS/header.js"></script>
</body>

