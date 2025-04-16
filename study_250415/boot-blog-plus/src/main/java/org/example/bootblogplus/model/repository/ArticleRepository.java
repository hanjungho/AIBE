package org.example.bootblogplus.model.repository;

import org.example.bootblogplus.model.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Spring
public interface ArticleRepository extends JpaRepository<Article, Long> {
    // 검색, 정렬
}
