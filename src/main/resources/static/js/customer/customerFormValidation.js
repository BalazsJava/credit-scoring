/**
 * Validates the customer form.
 * @returns {boolean} - Returns true if the form is valid, false otherwise.
 */
function validateCustomerForm() {
    const name = document.getElementById("name").value.trim();
    const age = document.getElementById("age").value.trim();
    const monthlyIncome = document.getElementById("monthlyIncome").value.trim();
    const dependents = document.getElementById("dependents").value.trim();

    let isValid = true;

    // Clear previous error messages
    clearErrorMessages();

    if (name === "") {
        isValid = false;
        displayError("nameError", "Name is required.");
    }

    if (age === "" || isNaN(age) || age <= 0) {
        isValid = false;
        displayError("ageError", "Age must be a positive number.");
    }

    if (monthlyIncome === "" || isNaN(monthlyIncome) || monthlyIncome < 0) {
        isValid = false;
        displayError("monthlyIncomeError", "Monthly income must be a non-negative number.");
    }

    if (dependents === "" || isNaN(dependents) || dependents < 0) {
        isValid = false;
        displayError("dependentsError", "Dependents must be a non-negative number.");
    }

    return isValid;
}

function displayError(elementId, message) {
    const errorElement = document.getElementById(elementId);
    errorElement.textContent = message;
    errorElement.classList.remove('d-none');
}

function clearErrorMessages() {
    const errorElements = document.querySelectorAll('.alert-danger');
    errorElements.forEach(el => {
        el.textContent = "";
        el.classList.add('d-none');
    });
}
