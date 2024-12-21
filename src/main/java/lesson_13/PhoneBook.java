package lesson_13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneBook {
    // Хэшмап, где ключ - строка, значение - список
    private final HashMap<String, List<String>> phoneBook;

    // Конструктор класса справочника
    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    // Пишем метод, где добавляется имя, фамилия и номер телефона. Если в списке отсутствует фамилия, добавляется новый элемент списка
    public void add(String firstName, String lastName, String phoneNumber) {
        phoneBook.computeIfAbsent(lastName, addPhoneNumber -> new ArrayList<>()).add(phoneNumber);
    }

    //Получаем все номера однофамильцев по фамилии
    public List<String> get(String lastName) {
        return phoneBook.getOrDefault(lastName, new ArrayList<>());
    }
}
