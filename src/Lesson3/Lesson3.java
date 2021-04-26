package Lesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson3 {
    public static void main(String[] args) {

        System.out.println("--------------- Задание 1 ---------------------------------");
        int[] binaryArray = new int[10];
        int[] binaryArrayInverted = new int[10];
        Random rand = new Random();
        for (int i = 0; i < binaryArray.length; i++) {
            binaryArray[i] = rand.nextInt(2);
        }
        System.out.println("Исходный массив");
        System.out.println(Arrays.toString(binaryArray));
        for (int i = 0; i < binaryArrayInverted.length; i++) {
            binaryArrayInverted[i] = binaryArray[i] == 0 ? 1 : 0;
        }
        System.out.println("Инвертированный массив");
        System.out.println(Arrays.toString(binaryArrayInverted));

        System.out.println("--------------- Задание 2 ---------------------------------");
        int[] intHundred = new int[100];
        for (int i = 0; i < intHundred.length; i++) {
            intHundred[i] = i + 1;
        }
        System.out.println(Arrays.toString(intHundred));

        System.out.println("--------------- Задание 3 ---------------------------------");
        int[] arr1 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Исходный массив");
        System.out.println(Arrays.toString(arr1));
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] < 6) arr1[i] = arr1[i] * 2;
        }
        System.out.println("Измененный массив");
        System.out.println(Arrays.toString(arr1));

        System.out.println("--------------- Задание 4 ---------------------------------");
        int length = 8;
        int[][] arrDiagonal = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j || ((length - 1) - i) == j) {
                    arrDiagonal[i][j] = 1;
                }
            }
        }
        System.out.println("Диагонали заполнены '1'");
        for (int i = 0; i < arrDiagonal.length; i++) {
            System.out.println(Arrays.toString(arrDiagonal[i]));
        }

        System.out.println("--------------- Задание 5 ---------------------------------");
        System.out.println(Arrays.toString(returnArr(5, 3)));

        System.out.println("--------------- Задание 6 ---------------------------------");
        int[] arr2 = new int[15];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = rand.nextInt(100);
        }
        System.out.println("Исходный массив");
        System.out.println(Arrays.toString(arr2));
        int[] minMax = {arr2[0], arr2[0]};
        for (int x : arr2) {
            minMax[0] = Math.min(x, minMax[0]);
            minMax[1] = Math.max(x, minMax[1]);
        }
        System.out.println("min и max массива: " + Arrays.toString(minMax));

        System.out.println("--------------- Задание 7 ---------------------------------");
        int len = 15;
        int[] arr3 = new int[len];
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = rand.nextInt(3);
        }
        System.out.println("Исходный массив");
        System.out.println(Arrays.toString(arr3));
        System.out.println("Точка равновесия в массиве есть: " + checkSum(arr3));

        System.out.println("--------------- Задание 8 ---------------------------------");
        int[] arr4 = {1, 5, 3, 32, 11, 4, 51, 2, 4, 8, 9, 14};
        Scanner shiftInput =new  Scanner(System.in);
        System.out.println("Введите значение свига - целое положительное или отрицательное число");
        int shift = shiftInput.nextInt();
        shiftArray(shift, arr4);
    }

    // Метод к заданию 5
    private static int[] returnArr(int len, int initialValue) {
        int[] arr1 = new int[len];
        Arrays.fill(arr1, initialValue);
        return arr1;
    }

    // Метод к заданию 7
    private static boolean checkSum(int[] arr3) {
        int sumTotal = 0; int checkIndex = 0;
        for (int x : arr3) {
            sumTotal += x;
        }
        int sumLeft = 0; int sumRight = sumTotal;
        for (int i = 0; i < arr3.length; i++) {
            sumLeft += arr3[i]; sumRight -= arr3[i];
            if (sumLeft == sumRight) {
                System.out.printf("Индекс равновесия - %d; сумма слева - %d, сумма справа - %d\n", i, sumLeft, sumRight);
                checkIndex++;
            }
        }
        return checkIndex > 0;
    }

    // Метод к заданию 8
    private static void shiftArray (int shift, int[] arr4) {
        System.out.println("Исходный массив");
        for( int x : arr4) {
            System.out.print(x + " ");
        }
        System.out.println();
        String shiftDirection = shift >= 0 ? "вправо" : "влево" ;
        System.out.printf("Сдвиг %s на %d\n", shiftDirection,  Math.abs(shift));
        /*
          Сдвиг означает увеличение индекса отображаемого элемента, т.е. при неизмененном массиве
          будем отодражать элементы со сдвигом. Ищем соответсвие при сдвиге вправо на 2
          j = 0 будет соответсвовать такое i, при котором (i + shift) % arr4.length = 0,
          j = 0 это теперь i = 11 (последний элемент)
         */
        for (int j = 0; j < arr4.length; j++) {
            for(int i = 0; i < arr4.length ; i++)
                if (shift >= 0) {
                    if (j == (i + shift) % arr4.length) System.out.print(arr4[i] + " ");
                } else {
                    int newShift = i + shift >= 0 ? (i + shift) % arr4.length : arr4.length - Math.abs((i + shift) % arr4.length);
                    if ( j == newShift) System.out.print(arr4[i] + " ");
                }
        }
    }
}