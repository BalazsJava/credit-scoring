var stompClient = null;

$(function () {
    const form = document.getElementById('webSocketForm');

    form.addEventListener('submit', function (event) {
        event.preventDefault(); // Prevent default form submission
    });

    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
});

function connect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    var socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnection(true);
        console.log('Connected: ' + frame);

        stompClient.subscribe('/table/customers', function (customerEntity) {
            var jsonBody = JSON.parse(customerEntity.body);
            displayCustomerEntity(jsonBody);
        });

        $("#connect").addClass('hidden');
        $("#disconnect, #customersTable").removeClass('hidden');
        $("#connection").text('Connected');
        $("#connection").css('color','green');
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnection(false);
    console.log("Disconnected");

    $("#connect").removeClass('hidden');
    $("#disconnect, #customersTable").addClass('hidden');

    $("#connection").text('Disconnected');
    $("#connection").css('color','red');
}

function setConnection(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#customersTable").show();
    }
    else {
        $("#customersTable").hide();
    }
    $("#customersTableBody").html("");
}

function displayCustomerEntity(entity) {
    var row = document.createElement("tr");

    row.appendChild(tableColumn("ID", entity.id));
    row.appendChild(tableColumn("Name", entity.name));
    row.appendChild(tableColumn("Age", entity.age));
    row.appendChild(tableColumn("Monthly Income", entity.monthlyIncome));
    row.appendChild(tableColumn("Number of Dependents", entity.dependents));
//    row.appendChild(tableColumn("Timestamp", formatDate(timestampEpoch)));
    $("#customersTableBody").append(row);
}

function tableColumn(label, text) {
    var e = document.createElement("td");
    e.setAttribute("data-label", label);
    e.appendChild(document.createTextNode(text));
    return e;
}

function formatDate(timestampEpoch) {
    var myDate = new Date(timestampEpoch);
    return myDate.getFullYear() + '-' +
    ('0' + (myDate.getMonth()+1)).slice(-2) + '-' +
    ('0' + myDate.getDate()).slice(-2) + ' ' +
    ('0' + (myDate.getHours())).slice(-2) +  ':' +
    ('0' + (myDate.getMinutes())).slice(-2) + ':' +
    myDate.getSeconds() + '+0000';
}
