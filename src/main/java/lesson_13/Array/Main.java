package lesson_13.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] array = {
                "Красный","Белый", "Желтый", "Оранжевый", "Черный",
                "Зеленый", "Синий", "Оранжевый", "Серебряный", "Фиолетовый",
                "Желтый", "Серый", "Голубой", "Оранжевый", "Коричневый"
        };

        System.out.println("Изначальный список из массива: \n" + Arrays.toString(array) + "\n");

        LinkedHashSet<String> set = new LinkedHashSet<>(Arrays.asList(array));

        System.out.println("Преобразованный список в хэшсет с удаленными дубликатами в порядке добавления: \n" + set + "\n");

        System.out.println("Количество слов в списке (без учета регистра):");
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : array) { // перебираем массив с цветами
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1); // Добавялем +1 в счетчик всякий раз, когда слово встречается
        }

        wordCount.forEach((word, count) -> System.out.println(word + ": " + count)); // Печатаем результат каждого элемента массива
    }
}