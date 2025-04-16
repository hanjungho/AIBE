package org.example.bootblogplus.model.form;

import org.example.bootblogplus.model.entity.Article;
import org.springframework.web.multipart.MultipartFile;

public record ArticleForm(String title, String content, MultipartFile imageFile) {
    public Article formToEntity(String imageUrl) {
        Article article = new Article();
        article.setTitle(this.title);
        article.setContent(this.content);
        article.setImageUrl(imageUrl); // 외부의 UploadService의 결과를 받아서 처리
        return article;
    }
    public static ArticleForm empty() {
        // 시맨틱 코딩
        return new ArticleForm("", "", null);
    }
}
