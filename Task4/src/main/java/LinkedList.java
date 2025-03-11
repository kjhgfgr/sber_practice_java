public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(int data) {
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

    public void addLast(int data) {

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

    public int removeFirst() {

        if (head == null) {
            System.out.print("List is empty");
        }

        int data = head.data;
        head = head.next;
        size--;

        if (head == null) {
            tail = null; // List is now empty
        }

        return data;
    }

    public int removeLast() {
        if (head == null) {
            System.out.print("List is empty");
        }

        if (head == tail) {
            int data = head.data;
            head = null;
            tail = null;
            size--;
            return data;
        }

        Node current = head;

        while (current.next != tail) {
            current = current.next;
        }

        int data = tail.data;
        tail = current;
        tail.next = null;
        size--;

        return data;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            System.out.print("Index out of bounds");
        }

        Node current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    public int size() {
        return size;
    }
}