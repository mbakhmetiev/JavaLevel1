package Lesson_4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson_4 {
	private static final int SIZE = 5; // Размер игрового поля, может быть 5 и 3
	private static final int DOTS = 4;// Кол-во фишек, может быть 3 и 4 соотв для поля 3х3 и 5х5
	private static final char DOT_EMPTY = '●';
	private static final char DOT_X = 'X';
	private static final char DOT_0 = '0';

	private static final char[][] MAP = new char[SIZE][SIZE];

	public static void main(String[] args) {
		initMap();
		printMap();
		while (true) {
			humanTurn();
			printMap();
			if (checkDiago(DOT_X) || checkLines(DOT_X)) {
				System.out.println("*** Побеждает человек ***");
				break;
			}
			if (isMapFull()) {
				System.out.println("*** Ничья ***");
				break;
			}
			computerTurn();
			printMap();
			if (checkDiago(DOT_0) || checkLines(DOT_0)) {
				System.out.println("*** Побеждает компьютер ***");
				break;
			}
			if (isMapFull()) {
				System.out.println("*** Ничья ***");
				break;
			}
		}
	}

	private static void initMap() {
		for (int i = 0; i < SIZE; i++) {
			Arrays.fill(MAP[i], DOT_EMPTY);
		}
	}

	private static void printMap() {
		for (int i = 0; i <= SIZE; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i = 0; i < SIZE; i++) {
			System.out.print((i + 1) + " ");
			for (int j = 0; j < SIZE; j++) {
				System.out.print(MAP[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void humanTurn() {
		int x;
		int y;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Введите координаты в формате X Y");
			x = readInt(scanner);
			y = readInt(scanner);
			if (x == -1 || y == -1) {
				System.out.println("Требуется вводить числовые значения");
				scanner.nextLine();
			} else if (x < 0 || x > SIZE || y < 0 || y > SIZE) {
				System.out.printf("Введите координаты из диапазона 1 : %1$d x 1 : %1$d\n", SIZE);
			} else if (MAP[x][y] != DOT_EMPTY) {
				System.out.println("Ячейка занята, введите координаты пустой ячейки");
			} else {
				break;
			}
		} while (true);
		MAP[x][y] = DOT_X;
	}

	private static int readInt(Scanner scanner) {
		return scanner.hasNextInt() ? scanner.nextInt() - 1 : -1;
	}

	private static void computerTurn() {
		int x;
		int y;
		Random rand = new Random();

		do {
			x = rand.nextInt(SIZE);
			y = rand.nextInt(SIZE);
		} while (MAP[x][y] != DOT_EMPTY);

		MAP[x][y] = DOT_0;
	}
	/*
	Логика проверки выигрыша разделена на проверку диагоналей и вертикалей с горизонталями
	Проверка диагоналей состоит в разбиении поля на квадраты в которых диагональ равна длине
	выигрышной комбинации.
	 */
	private static boolean checkDiago(char symbol) {
		int z = DOTS;
		boolean res = false;
		for (int y = 0; y <= SIZE - DOTS; y++) {
			z += y;
			for (int x = 0; x <= SIZE - DOTS; x++) {
				String diago1 = "";
				String diago2 = "";
				for (int i = y; i < z; i++) {
					if (x == y) {
						for (int j = x; j < z; j++) {
							if (i == j) diago1 += Character.toString(MAP[i][j]);
							if (((z - 1) - j + x) == i) diago2 += Character.toString(MAP[i][j]);
						}
						res = (res || checkWord(new String[]{diago1, diago2}, symbol));
					} else if (x > y) {
						for (int j = x; j < z + x; j++) {
							if (i == j - x) diago1 += Character.toString(MAP[i][j]);
							if ((z - j) == i) diago2 += Character.toString(MAP[i][j]);
						}
						res = (res || checkWord(new String[]{diago1, diago2}, symbol));
					} else {
						for (int j = x; j < z; j++) {
							if (i - y == j) diago1 += Character.toString(MAP[i][j]);
							if (((z - 1) - j) == i) diago2 += Character.toString(MAP[i][j]);
						}
						res = (res || checkWord(new String[]{diago1, diago2}, symbol));
					}
				}
			}
		}
		return res;
	}
    /*
    Проверка прямых проходом по вертикали и горизонтали
     */
	private static boolean checkLines(char symbol) {
		boolean res = false;
		for (int i = 0; i < SIZE; i++) {
			String line1 = "";
			String line2 = "";
			for (int j = 0; j < SIZE; j++) {
				line1 += Character.toString(MAP[i][j]);
				line2 += Character.toString(MAP[j][i]);
			}
			res = (res || checkWord(new String[]{line1, line2}, symbol));
		}
		return res;
	}
	private static boolean checkWord(String[] str1, char symbol ){
		boolean res = false;
		for (String x : str1) {
			res = (res || x.contains(winString(symbol)));
		} return res;
	}
	 private static String winString(char symbol) {
		String winString = "";
		 for (int i = 0; i < DOTS; i++) {
			 winString += Character.toString(symbol);
		 }
		 return winString;
	 }

	private static boolean isMapFull() {
		for (int i = 0; i <SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				if(MAP[i][j] == DOT_EMPTY) return false;
			}
		}
		return true;
	}
}