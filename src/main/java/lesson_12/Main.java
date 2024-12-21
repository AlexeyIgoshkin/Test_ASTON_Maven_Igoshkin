package lesson_12;

public class Main {
    public static void main(String[] args){
        // Создаем массивы
        String[][] array1 = {
                {"15", "134", "42", "75"},
                {"15", "14", "5", "3"},
                {"1876", "54", "56", "7"},
                {"1483", "10", "6", "47"}
        };

        String[][] array2 = {
                {"15", "134", "42", "75"},
                {"15", "14", "5", "5"},
                {"1876", "54", "1", "7"},
                {"1483", "6", "424", "14", "5"}
        };

        String[][] array3 = {
                {"15", "134", "42", "75"},
                {"15", "14", "5", "3"},
                {"18", "54", "0O", "7"},
                {"1483", "8", "6", "47"}
        };

        // Ловим массивы на ошибки через статический метод класса ArrayValidation
        System.out.println("\nМассив №1:");

        try {
            ArrayValidation.arrayException(array1);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("\nМассив №2:");

        try {
            ArrayValidation.arrayException(array2);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nМассив №3:");

        try {
            ArrayValidation.arrayException(array3);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
}
