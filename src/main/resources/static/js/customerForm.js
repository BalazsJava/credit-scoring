// To debug javascript, put this somewhere in the code:
// debugger;
// Then when you open the web page, and inspect the page (or F12), then it will stop at that point
// You can step forward there in the code by F10, or let it run until the next debugger; with F8

document.addEventListener("DOMContentLoaded", function() {
    // Load initial customer data
    loadCustomers();

    // Handle form submission
    document.getElementById("customerForm").addEventListener("submit", async function(event) {
        event.preventDefault();

        // Validate form data
        if (!validateCustomerForm()) {
            return; // Stop form submission if validation fails
        }

        const formData = new FormData(this);
        const customer = {
            name: formData.get("name"),
            age: formData.get("age"),
            monthlyIncome: formData.get("monthlyIncome"),
            dependents: formData.get("dependents")
        };

        try {
            const response = await fetch('/customer', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(customer)
            });

            if (!response.ok) {
                throw new Error('Network response was not ok');
            }

            const newCustomer = await response.json();
            addCustomerToTable(newCustomer);

            // Show popup with the new customer ID
            document.getElementById('customerId').textContent = newCustomer.id;
            const alertPopup = document.getElementById('alertPopup');
            alertPopup.classList.remove('d-none');

            // Hide the popup after 5 seconds (5000 milliseconds)
            setTimeout(() => {
                alertPopup.classList.add('d-none');
            }, 5000);

            // Reset the form
            this.reset();
        } catch (error) {
            console.error('Failed to save customer:', error);
        }
    });
});

async function loadCustomers() {
    try {
        const response = await fetch('/customer/all');
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }

        const customers = await response.json();
        customers.forEach(customer => addCustomerToTable(customer));
    } catch (error) {
        console.error('Failed to load customers:', error);
    }
}

function addCustomerToTable(customer) {
    const tableBody = document.querySelector("#customerTable tbody");
    const row = document.createElement('tr');
    row.innerHTML = `
        <td>${customer.id}</td>
        <td>${customer.name}</td>
        <td>${customer.age}</td>
        <td>${customer.monthlyIncome}</td>
        <td>${customer.dependents}</td>
    `;
    tableBody.appendChild(row);
}
