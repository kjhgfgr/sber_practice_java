import java.util.Random;
import java.util.Scanner;

public class Tasks {
    public static void task1(){
        System.out.print("Hello World!");
    }

    public static void task2(){
        Scanner scan = new Scanner(System.in);
        System.out.print("a = ");
        int a = scan.nextInt();
        System.out.print("b = ");
        int b = scan.nextInt();

        int c = a / b;
        int d = a % b;

        System.out.print(a + " / " + b + " = " + c + " с остатком " + d);
    }

    public static void task3() {
        System.out.print("Введите слово: ");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String str_reversed = new StringBuilder(str).reverse().toString();

        if (str.equals(str_reversed)) {
            System.out.println(str + " палиндромом");
        }
        else {
            System.out.println(str + " не палиндромом");
        }
    }

    public static void task4() {
        System.out.println("Введите натуральное трехзначное число: ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int a = n/100;
        int b = (n/10)%10;
        int c = n%10;

        System.out.print("Сумма цифр: ");
        System.out.print(a+b+c);
    }

    public static void task5() {
        System.out.println("Введите ваш вес на земле в кг: ");
        Scanner scan = new Scanner(System.in);

        double P_earth = scan.nextInt();
        double P_moon = P_earth*0.17;
        System.out.print("Ваш вес на луне: ");
        System.out.print(P_moon);
    }

    public static void task6() {
        System.out.println("Введите натуральное число: ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        boolean prime = true;

        if (n < 2) {
            prime = false;
        }
        else {
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    prime = false;
                    break;
                }
            }
        }

        if (prime) {
            System.out.print(n + " простое число");
        }
        else {
            System.out.print(n + " не простое число");
        }
    }

    public static void task7() {
        System.out.println("Введите число членов последовательности Фибоначчи: ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        long[] fib = new long[n];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        for (int i = 0; i < n; i++) {
            System.out.print(fib[i] + ", ");
        }
    }

    public static void task8() {
        System.out.println("Enter the letter: ");
        Scanner scan = new Scanner(System.in);

        char win;
        Random random = new Random();
        char random_char = (char) ('A' + random.nextInt(26));

        while (true) {
            win = scan.next().toUpperCase().charAt(0);
            if (random_char == win) {
                System.out.println("You win!");
                break;
            }
            else if (random_char > win) {
                System.out.println("You’re too low");
            }
            else {
                System.out.println("You’re too high");
            }
        }
    }

    public static void task9() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите коэффициенты квадратного уравнения: ");
        System.out.print("a = ");
        double a = scan.nextDouble();
        System.out.print("b = ");
        double b = scan.nextDouble();
        System.out.print("c = ");
        double c = scan.nextDouble();

        double dis = b*b - 4*a*c;

        if (dis > 0) {
            double x_1 = (-b + Math.sqrt(dis)) / (2 * a);
            double x_2 = (-b - Math.sqrt(dis)) / (2 * a);
            System.out.println("x_1 = " + x_1 + ", x_2 = " + x_2);
        }
        else if (dis == 0) {
            double x = -b / (2 * a);
            System.out.println("x = " + x);
        }
        else {
            System.out.println("нет корней");
        }
    }

    public static void task10() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Введите число в десятичной системе счисления: ");
        int n = scan.nextInt();

        String result = "";
        String[] roman = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {100, 90, 50, 40, 10, 9, 5, 4, 1};

        for (int i = 0; i < values.length; i++) {
            while (n >= values[i]) {
                result += roman[i];
                n -= values[i];
            }
        }

        System.out.println("Римская запись: " + result);
    }

}
