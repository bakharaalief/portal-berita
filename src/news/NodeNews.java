package news;

public class NodeNews {
    private NodeNews prev,next;
    private News news;

    public NodeNews getPrev() {
        return prev;
    }

    public void setPrev(NodeNews prev) {
        this.prev = prev;
    }

    public NodeNews getNext() {
        return next;
    }

    public void setNext(NodeNews next) {
        this.next = next;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
