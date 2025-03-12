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

import fjavierjp.keepcomponents.backend.model.Purchase;
import fjavierjp.keepcomponents.backend.service.IService;

@RestController
@RequestMapping("/api")
public class PurchaseController
{
	public IService<Purchase> service;
	
	@GetMapping("/purchases")
	public ResponseEntity<List<Purchase>> index()
	{
		return ResponseEntity.ok(this.service.index());
	}
	
	@GetMapping("/purchases/{id}")
	public ResponseEntity<Purchase> show(@PathVariable long id)
	{
		return ResponseEntity.ok(this.service.show(id));
	}
	
	@PostMapping("/purchases")
	public ResponseEntity<Purchase> store(@RequestBody Purchase purchase)
	{
		return new ResponseEntity<Purchase>(this.service.store(purchase), HttpStatus.CREATED);
	}
	
	@PutMapping("/purchases/{id}")
	public ResponseEntity<Purchase> update(@RequestBody Purchase customer, @PathVariable long id)
	{
		return ResponseEntity.ok(this.service.update(customer, id));
	}
	
	@DeleteMapping("/purchases/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable long id)
	{
		this.service.delete(id);
	}
}
