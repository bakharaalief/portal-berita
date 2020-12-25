package author;

public class NodeAuthor {
    private NodeAuthor prev, next;
    private Author author;

    public NodeAuthor getPrev() {
        return prev;
    }

    public void setPrev(NodeAuthor prev) {
        this.prev = prev;
    }

    public NodeAuthor getNext() {
        return next;
    }

    public void setNext(NodeAuthor next) {
        this.next = next;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
