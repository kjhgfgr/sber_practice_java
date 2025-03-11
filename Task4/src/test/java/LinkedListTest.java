import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class LinkedListTest {

    @Test
    public void testAddFirst() {
        LinkedList list = new LinkedList();

        list.addFirst(1);

        assertEquals(1, list.get(0));
    }

    @Test
    public void testAddLast() {
        LinkedList list = new LinkedList();

        list.addLast(1);

        assertEquals(1, list.size());
    }

    @Test
    public void testRemoveFirst() {
        LinkedList list = new LinkedList();

        list.addFirst(1);
        list.addFirst(2);

        assertEquals(2, list.removeFirst());
    }

    @Test
    public void testRemoveLast() {
        LinkedList list = new LinkedList();

        list.addLast(1);
        list.addLast(2);

        assertEquals(1, list.removeFirst());
    }

    @Test
    public void testGet() {
        LinkedList list = new LinkedList();

        list.addLast(1);
        list.addLast(2);

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
    }

    @Test
    public void testSize() {
        LinkedList list = new LinkedList();
        assertEquals(0, list.size());

        list.addLast(1);
        assertEquals(1, list.size());

        list.addLast(2);
        assertEquals(2, list.size());

        list.removeFirst();
        assertEquals(1, list.size());

        list.removeLast();
        assertEquals(0, list.size());
    }
}
