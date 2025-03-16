package fjavierjp.keepcomponents.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fjavierjp.keepcomponents.backend.entity.Article;
import fjavierjp.keepcomponents.backend.service.IService;

@Controller
@RequestMapping("/articles")
public class ArticleController
{
	@Autowired
	private IService<Article> service;
	
	@GetMapping(produces = MediaType.TEXT_HTML_VALUE)
	public String index()
	{
		return "views/articles/index";
	}
	
	@GetMapping(value = "/create", produces = MediaType.TEXT_HTML_VALUE)
	public String create()
	{
		return "views/articles/form";
	}
	
	@GetMapping(value = "/edit/{id}", produces = MediaType.TEXT_HTML_VALUE)
	public String edit(@PathVariable long id, Model model)
	{
		Article article = this.service.show(id);
		model.addAttribute(article);
		return "views/articles/form";
	}
}
