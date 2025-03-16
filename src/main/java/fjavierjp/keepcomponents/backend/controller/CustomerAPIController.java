package fjavierjp.keepcomponents.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fjavierjp.keepcomponents.backend.entity.Customer;
import fjavierjp.keepcomponents.backend.service.IService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customers")
public class CustomerAPIController
{
	@Autowired
	public IService<Customer> service;
	
	@GetMapping
	public ResponseEntity<List<Customer>> index()
	{
		return ResponseEntity.ok(this.service.index());
	}
	
	@GetMapping("/search")
	public ResponseEntity<Page<Customer>> search(
		@RequestParam(defaultValue = "0") Integer page,
		@RequestParam(defaultValue = "10") Integer size,
		@RequestParam(defaultValue = "") String search
	)
	{
		return ResponseEntity.ok(this.service.search(page, size, search));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> show(@PathVariable long id)
	{
		return ResponseEntity.ok(this.service.show(id));
	}
	
	@PostMapping
	public ResponseEntity<Customer> store(@Valid @RequestBody Customer customer)
	{
		return new ResponseEntity<Customer>(this.service.store(customer), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Customer> update(@Valid @RequestBody Customer customer, @PathVariable long id)
	{
		return ResponseEntity.ok(this.service.update(customer, id));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable long id)
	{
		this.service.delete(id);
	}
}
