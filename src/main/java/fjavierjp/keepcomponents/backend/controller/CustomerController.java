package fjavierjp.keepcomponents.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fjavierjp.keepcomponents.backend.model.Customer;
import fjavierjp.keepcomponents.backend.service.IService;

@RestController
@RequestMapping("/api")
public class CustomerController
{
	public IService<Customer> service;
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> index()
	{
		return ResponseEntity.ok(this.service.index());
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> show(@PathVariable long id)
	{
		return ResponseEntity.ok(this.service.show(id));
	}
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> store(@RequestBody Customer customer)
	{
		return new ResponseEntity<Customer>(this.service.store(customer), HttpStatus.CREATED);
	}
	
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> update(@RequestBody Customer customer, @PathVariable long id)
	{
		return ResponseEntity.ok(this.service.update(customer, id));
	}
	
	@DeleteMapping("/customers/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable long id)
	{
		this.service.delete(id);
	}
}
