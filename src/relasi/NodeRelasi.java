package relasi;

import author.Author;
import category.Category;
import news.News;

public class NodeRelasi {
    private NodeRelasi prev, next;
    private Relasi relasi;

    public NodeRelasi getPrev() {
        return prev;
    }

    public void setPrev(NodeRelasi prev) {
        this.prev = prev;
    }

    public NodeRelasi getNext() {
        return next;
    }

    public void setNext(NodeRelasi next) {
        this.next = next;
    }

    public Relasi getRelasi() {
        return relasi;
    }

    public void setRelasi(Relasi relasi) {
        this.relasi = relasi;
    }
}
