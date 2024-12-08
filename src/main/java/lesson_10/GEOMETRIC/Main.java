package lesson_10.GEOMETRIC;

public class Main {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        Square square1 = new Square();
        Triangle triangle1 = new Triangle();

        System.out.println();
        System.out.println("КРУГ");
        circle1.mathCalculation(5);
        circle1.colors("Красный", "Оранжевый");

        System.out.println();
        System.out.println("КВАДРАТ");

        square1.mathCalculation(5);
        square1.colors("Желтый", "Черный");

        System.out.println();
        System.out.println("ТРЕУГОЛЬНИК");

        triangle1.mathCalculation(2,2,2);
        triangle1.colors("Зеленый","Фиолетовый");
    }
}
