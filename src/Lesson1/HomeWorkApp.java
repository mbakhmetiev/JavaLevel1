package Lesson1;
import java.util.Random;

public class HomeWorkApp {
	public static void main(String[] args) {
		Random rand = new Random(); // Решил здесь создать переменную рандом, чтобы каждый раз в методах не повторять
		printThreeWords();
		checkSumSigned( rand );
		printColor( rand );
		compareNumbers( rand );
	}

	public static void printThreeWords () {
		System.out.println("***************************************************************************************************************");
		System.out.println("2. Создайте метод printThreeWords(), который при вызове должен отпечатать в столбец три слова: Orange, Banana, Apple.");
		System.out.printf("_%s\n_%s\n_%s\n", "Orange", "Banana", "Apple");
	}

	public static void checkSumSigned(Random rand) {
		System.out.println("***************************************************************************************************************");
		System.out.println("3. Создайте метод checkSumSign(), в теле которого объявите две int переменные a и b ...");
		int a = rand.nextInt(100);
		int b = rand.nextInt(100) * -1;
		int sum = a + b;
		String result = ( sum  >= 0) ? ", Сумма положительная" : ", Сумма отрицательная" ;
		System.out.println("a = " + a + ", b = " + b + "; sum = " + sum + result);
	}

	public static void printColor(Random rand) {
		System.out.println("***************************************************************************************************************");
		System.out.println("4. Создайте метод printColor() в теле которого задайте int переменную value и инициализируйте ее любым значением...");
		String color;
		int value = (int)(Math.random()*(200 - (-100) +1 ) - 100); // Генерация случ целого от -100 до 200
		if ( value <= 0 ) color = "Красный";
		else if (value <= 100) color = "Желтый";
		else color = "Зеленый";
		System.out.println("value = " + value + ", " + color);
	}

	public static void compareNumbers(Random rand) {
		System.out.println("***************************************************************************************************************");
		System.out.println("5. Создайте метод compareNumbers(), в теле которого объявите две int переменные a и b...");
		int a = rand.nextInt(100); int b = rand.nextInt(100);
		String result = a >= b ? "a >= b" : "a < b";
		System.out.printf("a = %d, b = %d, %s\n", a, b, result);
	}
}