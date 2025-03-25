import java.util.Scanner;

class CheckEvenNum extends Exception {
    public CheckEvenNum(String s) {
        super(s);
    }
}

class Multiplication {
    public int multiplication(int a, int b) throws CheckEvenNum {
        if (a % 2 != 0 || b % 2 != 0) {
            throw new CheckEvenNum("Числа не четные.");
        }
        return a * b;
    }
}

public class EvenNum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Multiplication multiplication = new Multiplication();
        int a, b;

        try {
            System.out.println("Введите четные числа для произведения.");

            System.out.print("Первое число: ");
            a = scanner.nextInt();

            System.out.print("Второе число: ");
            b = scanner.nextInt();

            int result = multiplication.multiplication(a, b);
            System.out.println("Произведение: " + result);
            System.out.println("Вы молодец!");

        } catch (CheckEvenNum e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Вы ввели не число");
        } finally {
            System.out.println("Конец программы :0");
            scanner.close();
        }
    }
}
