public class LinkedListGeneric<T> {
    private NodeGeneric<T> head;
    private NodeGeneric<T> tail;
    private int size;

    public LinkedListGeneric() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(T data) {
        NodeGeneric<T> newNode = new NodeGeneric<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addLast(T data) {
        NodeGeneric<T> newNode = new NodeGeneric<>(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public T removeFirst() {
        if (head == null) {
            System.out.print("List is empty");
        }
        T data = head.data;
        head = head.next;
        size--;
        if (head == null) {
            tail = null; // List is now empty
        }
        return data;
    }

    public T removeLast() {
        if (head == null) {
            System.out.print("List is empty");
        }
        if (head == tail) {
            T data = head.data;
            head = null;
            tail = null;
            size--;
            return data;
        }

        NodeGeneric<T> current = head;
        while (current.next != tail) {
            current = current.next;
        }

        T data = tail.data;
        tail = current;
        tail.next = null;
        size--;
        return data;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            System.out.print("Index out of bounds");
        }
        NodeGeneric<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public int size() {
        return size;
    }
}
