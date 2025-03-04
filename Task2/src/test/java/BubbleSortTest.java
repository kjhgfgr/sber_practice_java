import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class BubbleSortTest {

    @Test
    public void testSortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testReverseArray() {
        int[] arr = {5, 4, 3, 2, 1};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    public void testArrayDuplicates() {
        int[] arr = {3, 1, 2, 3, 4, 1};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(new int[]{1, 1, 2, 3, 3, 4}, arr);
    }
}
