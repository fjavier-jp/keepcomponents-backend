package fjavierjp.keepcomponents.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fjavierjp.keepcomponents.backend.exception.ResourceNotFoundException;
import fjavierjp.keepcomponents.backend.model.Customer;
import fjavierjp.keepcomponents.backend.repository.CustomerRepository;

@Service
public class CustomerService implements IService<Customer>
{
	@Autowired
	private CustomerRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Customer> index()
	{
		return (List<Customer>) this.repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Customer show(long id)
	{
		return this.repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer " + id + " not found"));
	}

	@Override
	public Customer store(Customer customer)
	{
		return this.repository.save(customer);
	}

	@Override
	public Customer update(Customer customer, long id)
	{
		return this.repository.findById(id).map(customerDB -> {
			customerDB.setName(customer.getName());
			customerDB.setSurname(customer.getSurname());
			customerDB.setEmail(customer.getEmail());
			customerDB.setPhone(customer.getPhone());
			customerDB.setDob(customer.getDob());
			customerDB.setCompany(customer.getCompany());
			customerDB.setPosition(customer.getPosition());
			customerDB.setAddress(customer.getAddress());
			customerDB.setPostalCode(customer.getPostalCode());
			customerDB.setRegion(customer.getRegion());
			return this.repository.save(customerDB);
		}).orElseThrow(() -> new ResourceNotFoundException("Customer " + id + " not found"));
	}

	@Override
	public void delete(long id)
	{
		if (!this.repository.existsById(id))
		{
			throw new ResourceNotFoundException("Customer " + id + " not found");
		}
		this.repository.deleteById(id);
	}
}
