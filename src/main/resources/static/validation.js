document.addEventListener('DOMContentLoaded', function () {
    const form = document.getElementById('customerForm');

    form.addEventListener('submit', function (event) {
        event.preventDefault(); // Prevent default form submission

        const formData = new FormData(form);

        // Convert FormData to JSON
        const jsonData = {};
        formData.forEach((value, key) => {
            jsonData[key] = value;
        });

        // Send data to the /validateCustomer endpoint
        fetch('/validateCustomer', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(jsonData)
        })
        .then(response => response.json())
        .then(data => {
            if (data.valid) {
                form.submit(); // Submit the form if validation is successful
            } else {
                displayValidationErrors(data.errors); // Display validation errors
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
    });

    function displayValidationErrors(errors) {
        // Clear previous errors
        const errorElements = document.querySelectorAll('.validation-error');
        errorElements.forEach(element => element.remove());

        // Display new errors
        for (const field in errors) {
            const errorMessage = errors[field];
            const inputElement = document.querySelector(`[name="${field}"]`);
            if (inputElement) {
                const errorElement = document.createElement('div');
                errorElement.className = 'validation-error';
                errorElement.textContent = errorMessage;
                inputElement.parentNode.appendChild(errorElement);
            }
        }
    }
});