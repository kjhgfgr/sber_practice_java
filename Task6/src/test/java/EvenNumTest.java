import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EvenNumTest {

    private final Multiplication multiplication = new Multiplication();

    @Test
    void testMultiplication() throws CheckEvenNum {
        int result = multiplication.multiplication(2, 6);
        assertEquals(12, result);
    }

    @Test
    void testCheckEvenNum1() {
        Exception exception = assertThrows(CheckEvenNum.class, () -> {
            multiplication.multiplication(3, 7);
        });
        assertEquals("Числа не четные.", exception.getMessage());
    }

    @Test
    void testCheckEvenNum2() {
        Exception exception = assertThrows(CheckEvenNum.class, () -> {
            multiplication.multiplication(2, 7);
        });
        assertEquals("Числа не четные.", exception.getMessage());
    }
}
