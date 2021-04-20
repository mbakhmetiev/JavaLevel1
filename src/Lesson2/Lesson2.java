package Lesson2;
import java.util.Random;

public class Lesson2 {
    public static void main(String[] args) {
        Random rand = new Random();
        int a = rand.nextInt(20); int b = rand.nextInt(10);
        int y = (int)(Math.random()*(10 - (-10) +1 ) - 10);
        // Задание 1
        System.out.println("*********************************************");
        System.out.printf("a = %d; b = %d; cумма лежит в пределах от 10 до 20: %b\n", a, b, checkSum20 (a, b));
        // Задание 2
        System.out.println("*********************************************");
        System.out.println(valueIsPositiveString(y));
        // Задание 3
        System.out.println("*********************************************");
        System.out.printf("Число %d яляется положительным: %b\n", y, valueIsPositiveBool(y));
        // Задание 4
        System.out.println("*********************************************");
        int x = rand.nextInt(7);
        String tellNolies = "'Я не должен лгать'";
        System.out.printf("Написать %s %d раз\n", tellNolies, x);
        printString(tellNolies, x);
        // Задание 5
        System.out.println("*********************************************");
        int w = rand.nextInt(2022);
        System.out.printf("Год %d является високосным: %b", w, checkYear(w) );
    }
    // Метод задания 1
    private static boolean checkSum20(int a, int b) {
        return (a + b >= 10 && a + b <= 20);
    }
    // Метод задания 2
    private static String valueIsPositiveString(int i) {
        String result;
        result = (i >= 0) ? " Число положительное" : " Число отрицательное";
        return  i + result;
    }
    // Метод задания 3
    private static boolean valueIsPositiveBool(int z) {
        return ( z > 0);
    }
    // Метод задания 4
    private static void printString(String tellNolies, int x) {
        for (int i = 1; i <= x; i++ ) {
            System.out.println(tellNolies);
        }
    }
    // Метод задания 5
    private static boolean checkYear(int w) {
        return (w % 400 == 0 || (w % 4 == 0 && w % 100 != 0));
    }
}