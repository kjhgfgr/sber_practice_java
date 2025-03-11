public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(Object data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }

        size++;
    }

    public void addLast(Object data) {
        Node newNode = new Node(data);

        if (tail == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public Object removeFirst() {
        if (head == null) {
            System.out.print("List is empty");
            return null;
        }

        Object data = head.data;
        head = head.next;
        size--;

        if (head == null) {
            tail = null;
        }

        return data;
    }

    public Object removeLast() {
        if (head == null) {
            System.out.print("List is empty");
            return null;
        }

        if (head == tail) {
            Object data = head.data;
            head = null;
            tail = null;
            size--;
            return data;
        }

        Node current = head;

        while (current.next != tail) {
            current = current.next;
        }

        Object data = tail.data;
        tail = current;
        tail.next = null;
        size--;

        return data;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            System.out.print("Index out of bounds");
            return null; // Возвращаем null, если индекс вне границ
        }

        Node current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data; // Возвращаем объект
    }

    public int size() {
        return size;
    }
}