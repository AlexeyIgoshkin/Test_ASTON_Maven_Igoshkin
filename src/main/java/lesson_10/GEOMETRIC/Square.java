package lesson_10.GEOMETRIC;

public class Square extends GeometricFigure implements SquareInterface {

    @Override
    public void mathCalculation(double side) {
        double perimeter = side * 4;
        System.out.println("Периметр квадрата: " + perimeter);
        double acreage = side * side;
        System.out.println("Площадь квадрата: " + acreage);
    }

    @Override
    public void colors(String fillColor, String borderColor) {
        System.out.println("Цвет заливки: " + fillColor);
        System.out.println("Цвет границы: " + borderColor);
    }
}


