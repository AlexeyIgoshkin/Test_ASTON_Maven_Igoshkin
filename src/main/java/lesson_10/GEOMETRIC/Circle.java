package lesson_10.GEOMETRIC;

public class Circle extends GeometricFigure implements CircleInterface {

    @Override
    public void mathCalculation(double _radius) {
        double perimeter = Math.PI * 2 * _radius;
        System.out.println("Периметр круга: " + perimeter);
        double acreage = Math.PI * (_radius * _radius);
        System.out.println("Площадь круга: " + acreage);
    }

    @Override
    public void colors (String fillColor, String borderColor) {
        System.out.println("Цвет заливки: " + fillColor);
        System.out.println("Цвет границы: " + borderColor);
    }
}
