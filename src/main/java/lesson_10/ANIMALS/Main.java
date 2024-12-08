package lesson_10.ANIMALS;

public class Main {
    public static void main(String[] args) {

        // Перечень животных с аргументом имени
        Dog bobik = new Dog("Бобик");
        Dog laika = new Dog("Лайка");
        Cat barsik = new Cat("Барсик");
        Cat mitka = new Cat("Митька");
        Cat ryzhik = new Cat("Рыжик");

        System.out.println();
        System.out.println("ДЕЙСТВИЯ ЖИВОТНЫХ:");
        // Перечень действий животных
        bobik.run(252);
        laika.run(554);
        barsik.run(150);
        mitka.run(230);
        ryzhik.run(0);

        System.out.println();

        bobik.swim(6);
        laika.swim(354);
        barsik.swim(150);
        mitka.swim(-5);
        ryzhik.swim(0);


        System.out.println();
        System.out.println("КОЛИЧЕСТВО ЖИВОТНЫХ:");
        //Экземпляры котов едят из миски через аргументы метода
        barsik.eat(6,10); // 1 - количество еды, 2 - сколько хочет кот
        mitka.eat(16,10); // 1 - количество еды, 2 - сколько хочет кот
        ryzhik.eat(16,16); // 1 - количество еды, 2 - сколько хочет кот

        System.out.println();


        //Считаем количество созданных выше животных, котов и собак
        System.out.println("Количество животных: " + Animal.getAnimalCount());
        System.out.println("Количество котов: " + Cat.getCatCount());
        System.out.println("Количество собак: " + Dog.getDogCount());
        System.out.println();

        System.out.println();
        System.out.println("КОТЫ ИЗ МАССИВА:");
        // Массив из котов
        Cat[] cats = {
                new Cat("Тимоша"),
                new Cat("Мурзик"),
                new Cat("Беляш"),
                new Cat("Пухляш"),
        };

        // Создаем миску
        Bowl bowl1 = new Bowl(50); // Сколько пищи изначально

        int[] catsFoodAmount = {14, 13, 23, 32};  // Массив порций на каждого кота

        // Убираем порцию пищи в миске после каждого кота через метод removeFood (если едим из одной миски)
        for (int i = 0; i < cats.length; i++) {
            int foodInBowl = bowl1.getFoodAmount(); // Берем переменную из класса Bowl
            cats[i].eat(foodInBowl, catsFoodAmount[i]); // Кормим котов
            cats[i].isSatisfied(); // Проверяем сыт ли кот
            if (foodInBowl >= catsFoodAmount[i]) { // Выясняем съел ли кот меньше, чем в миске
                bowl1.removeFood(catsFoodAmount[i]); // Если да, отнимаем количество съеденного
            }
        }
        //Добавляем еду в миску
        System.out.println();
        bowl1.addFood(60);
        System.out.println("Теперь в миске " + bowl1.getFoodAmount() + " единиц пищи");


        System.out.println();
        System.out.println("КОЛИЧЕСТВО ЖИВОТНЫХ С УЧЕТОМ МАССИВА:");
        //Повторно считаем количество котов и животных после массива
        System.out.println("Количество животных: " + Animal.getAnimalCount());
        System.out.println("Количество котов: " + Cat.getCatCount());




    }
}
