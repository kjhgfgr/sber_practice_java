import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class LinkedListGenericTest {

    @Test
    public void testAddFirst() {
        LinkedListGeneric<Integer> list = new LinkedListGeneric<>();

        list.addFirst(1);

        assertEquals(Integer.valueOf(1), list.get(0));
    }

    @Test
    public void testAddLast() {
        LinkedListGeneric<Integer> list = new LinkedListGeneric<>();

        list.addLast(1);

        assertEquals(1, list.size());
    }

    @Test
    public void testRemoveFirst() throws Exception {
        LinkedListGeneric<Integer> list = new LinkedListGeneric<>();

        list.addFirst(1);
        list.addFirst(2);

        assertEquals(Integer.valueOf(2), list.removeFirst());
    }

    @Test
    public void testRemoveLast() throws Exception {
        LinkedListGeneric<Integer> list = new LinkedListGeneric<>();

        list.addLast(1);
        list.addLast(2);

        assertEquals(Integer.valueOf(2), list.removeLast());
    }


    @Test
    public void testGet() {
        LinkedListGeneric<Integer> list = new LinkedListGeneric<>();

        list.addLast(1);
        list.addLast(2);

        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));
    }


    @Test
    public void testSize() {
        LinkedListGeneric<Integer> list = new LinkedListGeneric<>();
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
