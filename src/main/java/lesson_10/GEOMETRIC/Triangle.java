package lesson_10.GEOMETRIC;

public class Triangle extends GeometricFigure implements TriangleInterface {

    @Override
    public void mathCalculation(double sideA, double  sideB, double  sideC) {
        double perimeter = sideA + sideB + sideC;
        System.out.println("Периметр треугольника: " + perimeter);
        double p = (sideA + sideB + sideC) / 2;
        double acreage = Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
        System.out.println("Площадь треугольника: " + acreage);
    }

    @Override
    public void colors(String fillColor, String borderColor) {
        System.out.println("Цвет заливки: " + fillColor);
        System.out.println("Цвет границы: " + borderColor);
    }
}