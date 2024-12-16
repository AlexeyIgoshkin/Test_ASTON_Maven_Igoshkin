package lesson_10.ANIMALS;
//1 ЗАДАНИЕ
public class Main {
    public static void main(String[] args) {

        // Перечень животных с аргументом имени
        Dog bobik = new Dog("Бобик");
        Dog laika = new Dog("Лайка");
        Cat barsik = new Cat("Барсик");
        Cat mitka = new Cat("Митька");
        Cat ryzhik = new Cat("Рыжик");

        System.out.println("\nДЕЙСТВИЯ ЖИВОТНЫХ:");

        // Перечень действий животных, длина дистанции в аргументе
        bobik.run(252);
        laika.run(554);
        barsik.run(150);
        mitka.run(230);
        ryzhik.run(-1);

        System.out.println();

        bobik.swim(6);
        laika.swim(354);
        barsik.swim(150);
        mitka.swim(-5);
        ryzhik.swim(0);

        System.out.println("\nКОЛИЧЕСТВО ЖИВОТНЫХ:");

        //Экземпляры котов едят из миски через аргументы метода
        barsik.eat(6,10); // 1 - количество еды, 2 - сколько хочет кот
        mitka.eat(16,10); // 1 - количество еды, 2 - сколько хочет кот
        ryzhik.eat(16,16); // 1 - количество еды, 2 - сколько хочет кот

        System.out.println();

        //Считаем количество созданных выше животных, котов и собак
        System.out.println("Количество животных: " + Animal.getAnimalCount());
        System.out.println("Количество котов: " + Cat.getCatCount());
        System.out.println("Количество собак: " + Dog.getDogCount());

        System.out.println("\n\nКОТЫ ИЗ МАССИВА:");

        // Массив из котов
        Cat[] cats = {
                new Cat("Тимоша"),
                new Cat("Мурзик"),
                new Cat("Беляш"),
                new Cat("Пухляш"),
        };

        // Создаем уникальную миску по классу
        Bowl bowl1 = new Bowl(50); // Сколько пищи в миске изначально

        int[] catsFoodAmount = {14, 13, 23, 32};  // Массив порций на каждого кота. Можно реализовать в аргументах массива.

        // Убираем порцию пищи в миске после каждого кота через метод removeFood (едим из одной миски)
        for (int i = 0; i < cats.length; i++) {
            int foodInBowl = bowl1.getFoodAmount(); // Берем переменную из класса Bowl
            cats[i].eat(foodInBowl, catsFoodAmount[i]); // Кормим кота
            cats[i].isSatisfied(); // Проверяем сыт ли кот
            if (foodInBowl >= catsFoodAmount[i]) { // Выясняем съел ли кот меньше, чем в миске
                bowl1.removeFood(catsFoodAmount[i]); // Если да, отнимаем количество съеденного. Если нет - он не трогает еду.
            }
        }

        //Добавляем еду в миску
        System.out.println();
        bowl1.addFood(60);
        System.out.println("Теперь в миске " + bowl1.getFoodAmount() + " единиц пищи");

        System.out.println("\nКОЛИЧЕСТВО ЖИВОТНЫХ С УЧЕТОМ МАССИВА:");
        //Повторно считаем количество котов и животных после массива, добавляем собак для полноты списка
        System.out.println("Количество животных: " + Animal.getAnimalCount());
        System.out.println("Количество котов: " + Cat.getCatCount());
        System.out.println("Количество собак: " + Dog.getDogCount());
    }
}
