const apiUrl = "http://localhost:8080/api/customers"
const id = document.getElementById('id').value;

function save(customerJSON)
{
	if (id)
	{
		fetch(apiUrl + "/" + id, {
			method: 'PUT',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(customerJSON)
		})
		.then(response => {
			if (!response.ok)
				response.json().then(data => {
					showErrors(data.errors);
				})
			else
				alert("Customer updated");
		})
		.catch(error => {
			alert(error)
		});
	}
	else
	{
		fetch(apiUrl + "/" + id, {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(customerJSON)
		})
		.then(response => {
			if (!response.ok)
				alert(response.statusText);
			else
			{
				alert("Customer created");
				setTimeout(() => history.back(), 5000);	
			}
		})
		.catch(error => alert(error));
	}
}

function formHandler(event)
{
	event.preventDefault();
	const formData = new FormData(event.target);
	const jsonData = Object.fromEntries(formData);
	save(jsonData);
}

function showErrors(errors)
{
	let show = "";
	for (let index = 0; index < errors.length; index++)
	{
		const error = errors[index];
		show += error.defaultMessage + "\n";
	}
	alert(show);
}

form.addEventListener("submit", formHandler)