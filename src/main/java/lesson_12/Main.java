package lesson_12;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
       /* В методе main() вызвать полученный метод, обработать возможные
        исключения MyArraySizeException и MyArrayDataException и
        вывести результат расчета.
        */
        Array array1 = new Array();
        array1.arrayExceptions(4);
    }
}
