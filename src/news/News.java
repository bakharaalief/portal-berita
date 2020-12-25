package news;

import java.time.LocalDateTime;

public class News {
    final String title, content;
    final LocalDateTime created;

    public News(String title, String content, LocalDateTime created){
        this.title = title;
        this.content = content;
        this.created = created;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreated() {
        return created;
    }
}
