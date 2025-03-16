const apiUrl = "http://localhost:8080/api/customers";
const url = "http://localhost:8080/customers";
const editLinks = document.querySelectorAll(".button-edit");
const deleteLinks = document.querySelectorAll(".button-delete");
const searchBox = document.querySelector('.topbar__form');
let search = "";

function searchBoxHandler(event)
{
	event.preventDefault();
	const formData = new FormData(searchBox);
	search = formData.get('search');
	loadCustomers(0, 10, search);
}

function loadCustomers(page = 0, size = 10, search = "")
{
	fetch(apiUrl + "/search?page=" + page + "&size=" + size + "&search=" + search)
		.then(response =>
		{
			if (!response.ok)
			{
				alert(response.statusText);
				return;
			}
			return response.json();
		})
		.then(data =>
		{
			let index;
			const tBody = document.getElementsByTagName("tbody")[0];
			tBody.innerHTML = '';
			for (index = 0; index < data.content.length; index++)
			{
				const customer = data.content[index];
				const tRow = document.createElement('tr');
				
				const tColumnId = document.createElement('td');
				tColumnId.textContent = customer.id;
				tRow.appendChild(tColumnId);
				
				const tColumnName = document.createElement('td');
				tColumnName.textContent = customer.name;
				tRow.appendChild(tColumnName);
				
				const tColumnSurname = document.createElement('td');
				tColumnSurname.textContent = customer.surname;
				tRow.appendChild(tColumnSurname);
				
				const tColumnEmail = document.createElement('td');
				tColumnEmail.textContent = customer.email;
				tRow.appendChild(tColumnEmail);
				
				const tColumnActions = document.createElement('td');
				const divCellActions = document.createElement('div');
				divCellActions.className = "cell__actions";
				
				const anchorEdit = document.createElement('a');
				anchorEdit.classList.add("button");
				anchorEdit.classList.add("button-edit");
				anchorEdit.href = url + "/edit/" + customer.id;
				anchorEdit.textContent = "Edit";
				divCellActions.appendChild(anchorEdit);
				
				const buttonDelete = document.createElement('button');
				buttonDelete.classList.add("button");
				buttonDelete.classList.add("button-delete");
				buttonDelete.textContent = "Delete";
				buttonDelete.addEventListener('click', deleteCustomerEventHandler);
				divCellActions.appendChild(buttonDelete);

				tColumnActions.appendChild(divCellActions);
				tRow.appendChild(divCellActions);
				tBody.appendChild(tRow);
			}	
		})
		.catch(error => alert(error));
}

function deleteCustomerEventHandler(event)
{
	event.preventDefault();
	if (confirm('Are you sure?'))
	{
		const button = event.target;
		const id = button.closest('tr').firstChild.textContent;
		deleteCustomer(id);
	}
}

function deleteCustomer(id)
{
	fetch(apiUrl + "/" + id, {
		method: 'DELETE',
		headers: {
			'Content-Type': 'application/json'
		},
	})
	.then(() => {
		alert('Customer deleted');
		loadCustomers("");
	})
	.catch(error => {
		alert(error);
	})
}

loadCustomers();
searchBox.addEventListener('submit', searchBoxHandler);