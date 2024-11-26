package lesson_2;
import java.util.Arrays;


public class Lesson2 {
    public static void main(String[] args) {
        //1 задание
        System.out.println("\n1 ЗАДАНИЕ");
        printThreeWords();

        //2 задание
        System.out.println("\n2 ЗАДАНИЕ");
        checkSumSign(3,-4);

        //3 задание
        System.out.println("\n3 ЗАДАНИЕ");
        printColor(34);

        //4 задание
        System.out.println("\n4 ЗАДАНИЕ");
        compareNumbers(54,54);

        //5 задание
        System.out.println("\n5 ЗАДАНИЕ");
        summWithin(9, 3);

        //6 задание
        System.out.println("\n6 ЗАДАНИЕ");
        numberPositiveNegative(-1);

        //7 задание
        System.out.println("\n7 ЗАДАНИЕ");
        booleanPositiveNegative(-25);

        //8 задание
        System.out.println("\n8 ЗАДАНИЕ");
        intString(4, "Печатаю текст а раз");

        //9 задание
        System.out.println("\n9 ЗАДАНИЕ");
        leapYear(2024);

        //10 задание
        System.out.println("\n10 ЗАДАНИЕ");
        reversedArray();

        //11 задание
        System.out.println("\n11 ЗАДАНИЕ");
        oneHundred();

        //12 задание
        System.out.println("\n12 ЗАДАНИЕ");
        lessThanSix();

        //13 задание
        System.out.println("\n13 ЗАДАНИЕ");
        squareArray(11);

        //14 задание
        System.out.println("\n14 ЗАДАНИЕ");
        intValue(6, 15);
    }


    /* 1. Создайте метод printThreeWords(), который при вызове должен отпечатать в столбец три слова: Orange, Banana, Apple.*/
    public static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    /* 2. Создайте метод checkSumSign(), в теле которого объявите
    две int переменные a и b, и инициализируйте их любыми
    значениями, которыми захотите. Далее метод должен
    просуммировать эти переменные, и если их сумма больше
    или равна 0, то вывести в консоль сообщение “Сумма
    положительнаяˮ, в противном случае - “Сумма
    отрицательнаяˮ;*/
    public static void checkSumSign(int a, int b) {
        int c = a + b;
        if (c >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    /* 3. Создайте метод printColor() в теле которого задайте int
    переменную value и инициализируйте ее любым значением.
    Если value меньше 0 (0 включительно), то в консоль метод
    должен вывести сообщение “Красныйˮ, если лежит в пределах
    от 0 (0 исключительно) до 100 (100 включительно), то
    “Желтыйˮ, если больше 100 (100 исключительно) - “Зеленыйˮ;*/
    public static void printColor(int value) {
        if (value <= 0) {
            System.out.println("\u001B[31mКрасный\u001B[0m");
        } else if (value > 0 && value <= 100) {
            System.out.println("\u001B[33mЖелтый\u001B[0m");
        } else if (value > 100) {
            System.out.println("\u001B[32mЗеленый\u001B[0m");
        } else {
            System.out.println("Невообразимая ошибка числа");
        }
    }

    /* 4. Создайте метод compareNumbers(), в теле которого
    объявите две int переменные a и b, и инициализируйте их
    любыми значениями, которыми захотите. Если a больше или
    равно b, то необходимо вывести в консоль сообщение “a >=
    bˮ, в противном случае “a < bˮ;*/
    public static void compareNumbers(int a, int b) {
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    /* 5. Напишите метод, принимающий на вход два целых числа и
    проверяющий, что их сумма лежит в пределах от 10 до 20
    (включительно), если да – вернуть true, в противном случае –
    false.*/
    public static void summWithin(int a, int b) {
        boolean summ;
        int c = a + b;
        if (c > 9 && c < 19) {
            summ = true;
            System.out.println("Сумма чисел в диапазоне 10-20: \u001B[32m" + summ + "\u001B[0m");
        } else {
            summ = false;
            System.out.println("Сумма чисел не в диапазоне 10-20: \u001B[31m" + summ + "\u001B[0m");
        }
    }

    /* 6. Напишите метод, которому в качестве параметра передается
    целое число, метод должен напечатать в консоль, положительное
    ли число передали или отрицательное. Замечание: ноль считаем
    положительным числом.*/
    public static void numberPositiveNegative(int a) {
        if (a >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    /* 7. Напишите метод, которому в качестве параметра передается
    целое число. Метод должен вернуть true, если число
    отрицательное, и вернуть false если положительное.
    Замечание: ноль считаем положительным числом.*/
    public static void booleanPositiveNegative(int a) {
        boolean typeNumber;
        if (a >= 0) {
            typeNumber = true;
            System.out.println("\u001B[32m" + typeNumber + "\u001B[0m");
        } else {
            typeNumber = false;
            System.out.println("\u001B[31m" + typeNumber + "\u001B[0m");
        }
    }

    /* 8. Напишите метод, которому в качестве аргументов
    передается строка и число, метод должен отпечатать в
    консоль указанную строку, указанное количество раз;*/
    public static void intString(int a, String str) {
        for (int i = 0; i < a; i++) {
            System.out.println(str);
        }
    }

    /* 9. Напишите метод, который определяет, является ли год
    високосным, и возвращает boolean (високосный - true, не
    високосный - false). Каждый 4-й год является високосным,
    кроме каждого 100-го, при этом каждый 400-й – високосный.*/
    public static void leapYear(int year) {
        boolean leap;
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            leap = true;
            System.out.println("\u001B[32m" + leap + "\u001B[0m: " + year + " год - високосный");
        } else {
            leap = false;
            System.out.println("\u001B[31m" + leap + "\u001B[0m: " + year + " год не високосный");
        }
    }

    /* 10. Задать целочисленный массив, состоящий из элементов 0
    и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и
    условия заменить 0 на 1, 1 на 0;*/
    public static void reversedArray() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /* 11. Задать пустой целочисленный массив длиной 100. С
    помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 ...
    100;*/
    public static void oneHundred() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
            }
        System.out.println(Arrays.toString(array));
    }

    /* 12. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по
    нему циклом, и числа меньшие 6 умножить на 2;*/
    public static void lessThanSix() {
        int[] massive = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < massive.length; i++) {
            if (massive [i] < 6) {
                massive [i] *= 2;
            }
        }
        System.out.println(Arrays.toString(massive));
    }

    /* 13. Создать квадратный двумерный целочисленный массив
    (количество строк и столбцов одинаковое), и с помощью цикла
    (-ов) заполнить его диагональные элементы единицами (можно
    только одну из диагоналей, если обе сложно). Определить
    элементы одной из диагоналей можно по следующему
    принципу: индексы таких элементов равны, то есть [0][0], [1][1],
    [2][2], ..., [n][n];*/
    public static void squareArray(int counter) {
        int[][] table = new int [counter][counter];
        int var = 1;
        for (int i = 0; i < table.length; i++) {
            /* Если нужно заполнить значениями:
            for (int j = 0; j < counter; j++) {
                table [i][j] = var++;
            }
             */
            table [i][i] = 1;
            table [i][counter - i - 1] = 1;
        }

        for (int i = 0; i < counter; i++) {
            for (int j = 0; j < counter; j++) {
                System.out.print(table[i][j] + " ");
            }
        System.out.println();
        }

    }

    /* 14. Написать метод, принимающий на вход два аргумента: len и
    initialValue, и возвращающий одномерный массив типа int длиной
    len, каждая ячейка которого равна initialValue.*/
    public static void intValue(int len, int initialValue) {
        int[] arrValue = new int [len];
        for (int i = 0; i < len; i++) { /* Но можно и как Arrays.fill(arrValue, initialValue) */
            arrValue[i] = initialValue;
            }
        System.out.println(Arrays.toString(arrValue));
    }

}