<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
    <title>Restaurant Billing System - Admin</title>
    <style>
        body{
            margin-left:20px;
        }
    </style>
</head>
<body>
    
    <jsp:include page="header.jsp"/>
    <h3 class="ml-4">Hey Admin!</h3>
    <style>
        #error{
          display:none;
        }
        </style>
        <div class="columns is-mobile">
          <div class="column is-half is-offset-one-quarter">
            <form class="is-centered">
            <p class="title">Staff Registeration</p>
            <div class="field ">
              <label class="label">Name</label>
              <div class="control">
                <input class="input" id="fullName" type="text" placeholder="Please Enter Fullname">
                <span class="icon is-small is-left">
                <i class="fas fa-envelope"></i>
              </span>
              </div>
            </div>
        
            <div class="field">
              <label class="label">Age</label>
              <div class="control">
                <input class="input" id="age" type="number" placeholder="Please Enter Age">
                <span class="icon is-small is-left">
                <i class="fas fa-envelope"></i>
              </span>
              </div>
            </div>
        
            <div class="field">
              <label class="label">Email</label>
              <div class="control">
                <input class="input" id="email" type="email" placeholder="Please Enter Email">
                <span class="icon is-small is-left">
                  <i class="fas fa-envelope"></i>
                </span>
            </div>
        
            <div class="field">
              <label class="label">Password</label>
              <div class="control">
                <input class="input" id="password" type="password" placeholder="Please Enter Password">
                <span class="icon is-small is-left">
                  <i class="fas fa-envelope"></i>
                </span>
            </div>
            <div class="field">
                <label class="label">Confirm Password</label>
                <div class="control">
                  <input class="input" id="confirm-password" type="password" placeholder="Please Re-Enter Password">
                  <span class="icon is-small is-left">
                    <i class="fas fa-envelope"></i>
                  </span>
              </div>
        
            <div class="field">
              <label class="label">Role</label>
              <div class="control">
                <div class="select" >
                  <select id="role">
                    <option>CHEF</option>
                    <option>CASHIER</option>
                    <option>OWNER</option>
                  </select>
                </div>
              </div>
            </div>
            <span class="icon is-small is-left">
            <i class="fas fa-envelope"></i>
            </span>
        
            <div class="field is-grouped">
              <div class="control">
                <button id="submit-button" type="submit" class="button is-link">Submit</button>
              </div>
              <div class="control">
                <button id="cancel-button" class="button is-link is-light">Cancel</button>
              </div>
            </div>
            <ul id="error">
            </ul>
            </form>
          </div>
        </div>
    <script src="/JS/admin.js"></script>
    
</body>
</html>