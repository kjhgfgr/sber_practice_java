import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class QuickSortTest {

    @Test
    public void testSortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testReverseArray() {
        int[] arr = {5, 4, 3, 2, 1};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    public void testArrayDuplicates() {
        int[] arr2 = {3, 1, 2, 3, 4, 1};
        QuickSort.quickSort(arr2, 0, arr2.length - 1);
        assertArrayEquals(new int[]{1, 1, 2, 3, 3, 4}, arr2);
    }

}