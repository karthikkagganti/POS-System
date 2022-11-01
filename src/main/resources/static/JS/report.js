const list = document.getElementById("report-list");
const button = document.getElementById("generate-report");
const content = document.getElementById("report-content");
var reports = [];
var flag = 0;

const today = new Date();
const dd = String(today.getDate()).padStart(2, "0");
const mm = String(today.getMonth() + 1).padStart(2, "0"); //January is 0!
const yyyy = today.getFullYear();
today = yyyy + "-" + mm + "-" + dd;

fetchContent();
button.addEventListener("click", function (event) {
  event.preventDefault();
  generateReports();
});

function checkFlag() {
  reports.forEach((ele) => {
    if (ele.reportDate === today) {
      flag = 1;
    } else {
      flag = 0;
    }
  });
}
async function generateReports() {
  checkFlag();
  if (flag == 0) {
    let response = await fetch("/report", {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
    });
    let reportid = await response.json();
    fetchReport(reportid);
  }
}

function displayReports(array) {
  list.textContent = "";
  array.forEach((element) => {
    let li = document.createElement("li");
    li.innerHTML = `
       <div class="column">
            <div class="card" style="width:250px;height:250px">
                <div class="card-content">
                    <div class="media-content">
                        <p class="title is-4">${element.reportDate}</p>
                        <span class="icon is-small is-left">
                            <i class="fas fa-envelope"></i>
                        </span>
                        <p class="subtitle is-6">this is the daily report generated for the date ${element.reportDate}</p>
                        <a onclick="temp(${element.reportid})" class="button is-link">View More</a>
                    </div>
                </div>
            </div>
        </div>
       `;
    list.appendChild(li);
  });
}

function deleteReport(id) {
  fetch(`/report/${id}`, {
    method: "DELETE",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
  }).then((response) => console.log(response));

  location.reload();
}
async function fetchContent() {
  let response = await fetch(`/report`);
  array = await response.json();
  reports = array;
  displayReports(array);
}
async function fetchReport(id) {
  let response = await fetch(`/report/${id}`);
  let array = await response.json();
  fetchContent();
  return array;
}

async function temp(id) {
  console.log(id);
  let array = await viewReport(id);
  console.log(array);
  let ordered_list = document.getElementById("order-list");
  let expenses_list = document.getElementById("expense-list");
  let reportDate = document.getElementById("reportDate");
  let report_subtitle = document.getElementById("report-subtitle");
  let sales = document.getElementById("sales");
  report_subtitle.innerHTML = `total amount after expenses: ₹${array.total}`;
  sales.innerHTML = `Number Of Orders: ${array.noSales} `;
  reportDate.innerHTML = `${array.reportDate}`;
  ordered_list.innerHTML = ``;
  array.orderedItems.forEach((element) => {
    let li = document.createElement("li");
    li.innerHTML = `
        <div class="cards">
        <div class="card" style="width: 200px; height: 200px">
          <div class="card-content">
            <div class="media-content">
              <p class="title is-5">Item: ${element.itemName}</p>
              <p class="subtitle is-5">Item quantity:${element.quantity}</p>
              <p class="subtitle is-5">subtotal: ₹${element.subTotal}</p>
            </div>
          </div>
        </div>
        </div>
        `;
    ordered_list.appendChild(li);
  });
  expenses_list.innerHTML = ``;
  array.expenses.forEach((element) => {
    let li = document.createElement("li");
    li.innerHTML = `
        <div class="column">
          <div class="card" style="width: 200px; height: 100px">
            <div class="card-content">
              <div class="media-content">
                <p class="title is-5">${element.name}</p>
                <p class="subtitle is-5">amount: ₹${element.amount}</p>
              </div>
            </div>
          </div>
        </div>
        `;
    expenses_list.appendChild(li);
  });

  let area = document.getElementById("view-area");
  area.style.display = "block";
}

async function viewReport(id) {
  let response = await fetch(`/report/${id}`);
  let array = await response.json();
  return array;
}
function closeWindow() {
  console.log("here");
  document.getElementById("view-area").style.display = "none";
}
