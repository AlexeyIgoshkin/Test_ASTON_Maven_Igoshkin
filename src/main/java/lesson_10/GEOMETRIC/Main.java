package lesson_10.GEOMETRIC;
//2 ЗАДАНИЕ
public class Main {
    public static void main(String[] args) {

        // Экземпляры фигур с аргументами
        Circle circle1 = new Circle(22,"Красный","Оранжевый");
        Square square1 = new Square(7,"Желтый","Черный");
        Triangle triangle1 = new Triangle(5,4,5,"Зеленый","Фиолетовый");
        System.out.println();

        // Вызов переопределенных методов интерфейса
        // Расчеты в едином методе, цвета в едином методе
        circle1.mathCalculation();
        circle1.colors();

        System.out.println();

        square1.mathCalculation();
        square1.colors();

        System.out.println();

        triangle1.mathCalculation();
        triangle1.colors();

        System.out.println();

        // Реализация квадрата через дефолтные методы интерфейса
        square1.perimeterSquare();
        square1.acreageSquare();
    }
}
