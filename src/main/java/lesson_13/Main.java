package lesson_13;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] array = {
                "Красный","Белый", "Желтый", "Оранжевый", "Черный",
                "Зеленый", "Синий", "Оранжевый", "Серебряный", "Фиолетовый",
                "Желтый", "Серый", "Голубой", "Оранжевый", "Коричневый"
        };

        System.out.println("Изначальный список из массива: \n" + Arrays.toString(array));

        LinkedHashSet<String> set = new LinkedHashSet<>(Arrays.asList(array));

        System.out.println();

        System.out.println("Преобразованный список в хэшсет с удаленными дубликатами в порядке добавления: \n" + set);
        System.out.println();

        System.out.println("Хэшмап для подсчета количества слов в списке (без учета регистра):");
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : array) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        wordCount.forEach((word, count) -> System.out.println(word + ": " + count));

        System.out.println();

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Александр", "Васильев", "+79991234567");
        phoneBook.add("Мария", "Беляева", "+79234567890"); // Фамилия повторяется 3 раза
        phoneBook.add("Екатерина", "Федорова", "+79012345678");
        phoneBook.add("Михаил", "Соколов", "+79876543210");
        phoneBook.add("Ольга", "Беляева", "+79995555555"); // Фамилия повторяется 3 раза
        phoneBook.add("Денис", "Морозов", "+79664443322"); // Фамилия повторяется 2 раза
        phoneBook.add("Анна", "Кузнецова", "+79551231234");
        phoneBook.add("Иван", "Новиков", "+79267778899");
        phoneBook.add("Алексей", "Морозов", "+79664443322"); // Фамилия повторяется 2 раза
        phoneBook.add("Татьяна", "Беляева", "+79993334455"); // Фамилия повторяется 3 раза
        phoneBook.add("Виктор", "Павлов", "+79880009999");
        phoneBook.add("Алексей", "Морозов", "+79623424242"); // Добавляем Алексею Морозову еще один номер. Фамилия повторяется 3 раза
        phoneBook.get("Павлов");

        List<String> telephones1 = phoneBook.get("Морозов");
        List<String> telephones2 = phoneBook.get("Беляева");
        System.out.println("Телефоны по искомой фамилии: " + telephones1);
        System.out.println("Телефоны по искомой фамилии: " + telephones2);

    }
}