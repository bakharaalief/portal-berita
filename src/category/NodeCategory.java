package category;

public class NodeCategory {
    private NodeCategory prev, next;
    private Category category;

    public NodeCategory getPrev() {
        return prev;
    }

    public void setPrev(NodeCategory prev) {
        this.prev = prev;
    }

    public NodeCategory getNext() {
        return next;
    }

    public void setNext(NodeCategory next) {
        this.next = next;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
