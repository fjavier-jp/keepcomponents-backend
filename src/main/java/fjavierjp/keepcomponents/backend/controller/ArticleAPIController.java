package fjavierjp.keepcomponents.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import fjavierjp.keepcomponents.backend.entity.Article;
import fjavierjp.keepcomponents.backend.service.IService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ArticleAPIController
{
	@Autowired
	public IService<Article> service;
	
	@GetMapping("/articles")
	public ResponseEntity<List<Article>> index()
	{
		return ResponseEntity.ok(this.service.index());
	}
	
	@GetMapping("/articles/{id}")
	public ResponseEntity<Article> show(@PathVariable long id)
	{
		return ResponseEntity.ok(this.service.show(id));
	}
	
	@PostMapping("/articles")
	public ResponseEntity<Article> store(@Valid @RequestBody Article article)
	{
		return new ResponseEntity<Article>(this.service.store(article), HttpStatus.CREATED);
	}
	
	@PutMapping("/articles/{id}")
	public ResponseEntity<Article> update(@Valid @RequestBody Article article, @PathVariable long id)
	{
		return ResponseEntity.ok(this.service.update(article, id));
	}
	
	@DeleteMapping("/articles/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable long id)
	{
		this.service.delete(id);
	}
}
