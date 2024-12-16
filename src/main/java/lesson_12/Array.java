package lesson_12;

import java.util.Arrays;

public class Array {
    // Создаем метод с числом на вход
    public void arrayExceptions(int size) throws MyArraySizeException, MyArrayDataException {

        //Убеждаемся, что массив имеет размер 4х4, иначе - выкидываем ошибку размера.
        if (size != 4) {
            throw new MyArraySizeException("Допустимый размер массива: 4х4. Вы пытаетесь создать " + size + "х"+ size +".");
        }

        //Создаем массив
        String[][] array = new String[size][size];

        //Заполняем массив строковым значением по умолчанию - "1". По умолчанию сумма преобразованных ячеек = 16.
        for (int i = 0; i < array.length; i++) {
            Arrays.fill(array[i], "1");
        }

        // Меняем случайные ячейки массива случайными данными
        array[2][3] = "2";
        array[3][3] = "6";
        array[1][2] = "4";
        array[0][2] = "8";

        // Считаем данные всех ячеек массива через переменную summ
        int summ = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++){

                //Ловим ошибку данных
                try {

                    //Преобразовываем строки массива в целочисленные значения
                    summ += Integer.parseInt(array[i][j]);
                } catch(NumberFormatException e) {
                    /* Тут я не разобрался. В случае выбрасывания ошибки, программа прерывается после первого же исключения.
                    Если MyArrayDataException использовать в качестве аргумента catch, java указывает на неверный тип исключения, так как это именно ошибка формата чисел.
                    Остается использовать логирование через sout, чтобы отрабатывал все неправильные значения, а не только первое.
                    Оставляю "throw new MyArrayDataException", так как по заданию мы должны использовать собственное исключение*/

                    //System.out.println("Неправильные данные в ячейке " + i + "-" + j+ ": " + array[i][j]);
                    throw new MyArrayDataException("Неправильные данные в ячейке " + i + "-" + j+ ": " + array[i][j]);
                }
            }
        }
        System.out.println("Сумма чисел массива: " + summ);
    }
}