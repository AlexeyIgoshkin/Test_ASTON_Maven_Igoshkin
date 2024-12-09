package lesson_10.GEOMETRIC;

public class Circle extends GeometricFigure implements GeometricInterface {
    public Circle(double _radius, String _fillColor, String _borderColor) {
        this.radius = _radius;
        this.fillColor = _fillColor;
        this.borderColor = _borderColor;
    }
    @Override
    public void mathCalculation() {
        double perimeter = Math.PI * 2 * radius;
        System.out.println("Периметр круга: " + perimeter);
        double acreage = Math.PI * (radius * radius);
        System.out.println("Площадь круга: " + acreage);
    }

    @Override
    public void colors () {
        System.out.println("Цвет заливки: " + fillColor);
        System.out.println("Цвет границы: " + borderColor);
    }
}
