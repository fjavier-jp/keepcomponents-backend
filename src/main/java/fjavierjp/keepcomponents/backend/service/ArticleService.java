package fjavierjp.keepcomponents.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fjavierjp.keepcomponents.backend.entity.Article;
import fjavierjp.keepcomponents.backend.exception.ResourceNotFoundException;
import fjavierjp.keepcomponents.backend.repository.ArticleRepository;

@Service
public class ArticleService implements IService<Article>
{
	@Autowired
	private ArticleRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Article> index()
	{
		return (List<Article>) this.repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Article show(long id)
	{
		return this.repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Article " + id + " not found"));
	}

	@Override
	public Article store(Article article)
	{
		return this.repository.save(article);
	}

	@Override
	public Article update(Article article, long id)
	{
		return this.repository.findById(id).map(articleDB -> {
			articleDB.setName(article.getName());
			articleDB.setDescription(article.getDescription());
			articleDB.setPrice(article.getPrice());
			articleDB.setStock(article.getStock());
			articleDB.setType(article.getType());
			articleDB.setProvider(article.getProvider());
			articleDB.setDate(article.getDate());
			return this.repository.save(articleDB);
		}).orElseThrow(() -> new ResourceNotFoundException("Article" + id + " not found"));
	}

	@Override
	public void delete(long id)
	{
		if (!this.repository.existsById(id))
		{
			throw new ResourceNotFoundException("Article " + id + " not found");
		}
		this.repository.deleteById(id);
	}
}
