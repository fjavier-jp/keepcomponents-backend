package fjavierjp.keepcomponents.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fjavierjp.keepcomponents.backend.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {}
