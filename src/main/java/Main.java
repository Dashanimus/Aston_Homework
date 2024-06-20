public class Main {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        checkSumRange(7, 3);
        printNumber(15);
        printBoolean(-9);
        printString("Aston", 3);
        System.out.println(checkYear(2024));
        changeArray();
        emptyArray();
        multiArray();
        squareArray();
        int[] array = lenArray(6, 9);
        for (int value : array) {
            System.out.print(value + " ");
        }
    }

    // Задание 1.
    public static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    // Задание 2.
    public static void checkSumSign() {
        int a = -10, b = 5, sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    // Задание 3.
    public static void printColor() {
        int value = 125;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    // Задание 4.
    public static void compareNumbers() {
        int a = 99, b = 100;
        System.out.println("a " + (a >= b ? ">=":"<") + " b");
    }

    // Задание 5.
    public static boolean checkSumRange(int num1, int num2) {
        int sum = num1 + num2;
        boolean b = sum >= 10 && sum <= 20;
        System.out.println(b);
        return b;
    }

    // Задание 6.
    public static void printNumber(int a) {
        if (a >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }

    // Задание 7.
    public static boolean printBoolean(int a) {
        boolean b = a < 0;
        System.out.println(b);
        return b;
    }

    // Задание 8.
    public static void printString(String word, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(word);
        }
    }

    // Задание 9.
    public static boolean checkYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Задание 10.
    public static void changeArray() {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == 0 ? 1 : 0;
        }
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println(" \n");
    }

    // Задание 11.
    public static void emptyArray() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println(" \n");
    }

    // Задание 12.
    public static void multiArray() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] = array[i] * 2;
            }
        }
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println(" \n");
    }

    // Задание 13.
    public static void squareArray() {
        int n = 3;
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            array[i][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j]);
            }
        }
        System.out.println();
    }

    // // Задание 14.
    public static int[] lenArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }
}
