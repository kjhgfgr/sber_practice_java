public class NodeGeneric<T> {
    T data;
    NodeGeneric<T> next;

    public NodeGeneric(T data) {
        this.data = data;
        this.next = null;
    }
}
