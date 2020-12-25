package relasi;

import author.Author;
import category.Category;
import news.News;

public class Relasi {
    final News news;
    final Author author;
    final Category category;

    public Relasi(News news, Author author, Category category){
        this.news = news;
        this.author = author;
        this.category = category;
    }

    public News getNews() {
        return news;
    }

    public Author getAuthor() {
        return author;
    }

    public Category getCategory() {
        return category;
    }
}
