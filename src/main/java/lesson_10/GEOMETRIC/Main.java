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
        circle1.getPerimeter();
        circle1.getArea();
        circle1.setFillColor();
        circle1.setBorderColor();
        circle1.printCalculations();

        System.out.println();

        square1.getPerimeter();
        square1.getArea();
        square1.setFillColor();
        square1.setBorderColor();
        square1.printCalculations();

        System.out.println();

        triangle1.getPerimeter();
        triangle1.getArea();
        triangle1.setFillColor();
        triangle1.setBorderColor();
        triangle1.printCalculations();

        System.out.println();

        // Реализация цвета через дефолтные методы интерфейса
        square1.fillColor("Красный");
        square1.backgroundColor("Черный");
        circle1.fillColor("Желтый");
        circle1.backgroundColor("Пепельный");
        triangle1.fillColor("Оранжевый");
        triangle1.backgroundColor("Белый");
    }
}
