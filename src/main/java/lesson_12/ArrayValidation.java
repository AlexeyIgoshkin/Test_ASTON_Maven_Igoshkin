package lesson_12;

public class ArrayValidation {
    // Создаем метод с проверками
    public static void arrayException(String[][] array) throws MyArraySizeException, MyArrayDataException {

        //Убеждаемся, что массив имеет 4 строки, иначе - выкидываем ошибку размера.
        if (array.length != 4) {
            throw new MyArraySizeException("Массив не обработан. Допустимый размер массива: 4х4. Вы пытаетесь создать " + array.length + "строк");
        }

        //Убеждаемся, что строка имеет 4 индекса, иначе - выкидываем ошибку размера.
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Массив не обработан. Допустимый размер массива: 4х4. Массив " + i + " содержит " + array[i].length + " элементов");
            }
        }

        //Убеждаемся, что в двумерном массиве нет значений, которые не могут быть преобразованы в int, иначе - выкидываем ошибку данных.
        int summ = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    summ += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Массив не обработан. Неправильные данные в ячейке " + i + "-" + j + ": " + array[i][j]);
                }
            }
        }
        System.out.println("Сумма чисел массива: " + summ);
    }
}