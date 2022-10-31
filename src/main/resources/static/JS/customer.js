const customer = document.createElement("template");
customer.innerHTML = `
<style>
#error{
  display:none;
}
#success{
	  display:none;
	}
</style>
<div class="columns is-mobile">
  <div class="column is-half is-offset-one-quarter">
    <form class="is-centered">
    <p class="title">Customer Registeration</p>
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
    </div>

    <div class="field">
      <label class="label">Mobile Number</label>
      <div class="control">
        <input class="input" id="mobileNumber" type="number" placeholder="Please Enter mobile number">
        <span class="icon is-small is-left">
          <i class="fas fa-envelope"></i>
        </span>
    </div>

    <div class="field">
      <label class="label">Gender</label>
      <div class="control">
        <div class="select" >
          <select id="gender">
            <option>Male</option>
            <option>Female</option>
            <option>Other</option>
          </select>
        </div>
      </div>
    </div>
    
    <span class="icon is-small is-left">
    <i class="fas fa-envelope"></i>
    </span>
    
    <div class="field">
    <label class="label">Feedback</label>
    <div class="control">
      <input class="input" id="feedback" type="text" placeholder="Please Enter The Feedback">
      <span class="icon is-small is-left">
      <i class="fas fa-envelope"></i>
    </span>
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
    <ul id="error"></ul>
    
    </form>
  </div>
</div>
`;

class Customer extends HTMLElement {
  connectedCallback() {
    this.attachShadow({ mode: "open" });
    this.shadowRoot.innerHTML = `
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
        `;

    this.shadowRoot.appendChild(customer.content.cloneNode(true));
    const button = this.shadowRoot.querySelector("#submit-button");
    const error = this.shadowRoot.querySelector("#error");

    const name = this.shadowRoot.querySelector("#fullName");
    const gender = this.shadowRoot.querySelector("#gender");
    const age = this.shadowRoot.querySelector("#age");
    const email = this.shadowRoot.querySelector("#email");
    const phone = this.shadowRoot.querySelector("#mobileNumber");
    const feedback = this.shadowRoot.querySelector("#feedback");
    const orderid = this.getAttribute("orderid");
    var err =[]
    
    button.addEventListener("click", function (event) {
        event.preventDefault();
        if (name.value === "") {
            err.push("Username is missing!");
          }
        if (email.value == "" || !email.value.includes("@")|| !email.value.includes(".")) {
            err.push("Email is missing or incorrect!");
          }
        if (age.value == "") {
            err.push("Age is missing!");
          }
          if (phone.value === "" || phone.value.length != 10) {
            err.push("Mobile Number is missing or incorrect!");
            
          }
          if (feedback.value === "") {
              err.push("The Feedback is missing!");
              
            }
        if (err.length !== 0) {
        error.textContent = ''
          error.style.display = "block";
          err.forEach((errors)=>{
        	  const li = document.createElement("li");
        	  li.innerHTML=`
        	  <p>${errors}</p>
        	  `
        	  error.appendChild(li)
          })
          err=[]
          
        } else {
          error.style.display = "none";
          registerCustomer();
        }
      });
    
    
    async function registerCustomer() {
      const formData = {
        name: name.value,
        age: age.value,
        gender: gender.value,
        email: email.value,
        mobile: phone.value,
        feedback: feedback.value
      };
      console.log(formData);
      let response= await fetch("http://localhost:8000/cust", {
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        method: "POST",
        body: JSON.stringify({
          name: formData.name,
          age: parseInt(formData.age),
          gender: formData.gender,
          email: formData.email,
          mobile: parseInt(formData.mobile),
          feedback: formData.feedback
        }),
      })
      let custid = await response.json();
      done();
      return custid;
    }
    
    function done(){
    	alert("Customer Feedback Collected")
    	name.value ='';
    	phone.value ='';
    	age.value ='';
    	gender.value ='';
    	email.value='';
    	feedback.value = '';
    }

  }
}

window.customElements.define("new-customer", Customer);
