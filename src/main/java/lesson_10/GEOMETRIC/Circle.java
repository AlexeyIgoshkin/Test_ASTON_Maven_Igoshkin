package lesson_10.GEOMETRIC;

public class Circle extends GeometricFigure implements GeometricInterface {
    double perimeter;
    double acreage;
    public Circle(double _radius, String _fillColor, String _borderColor) {
        this.radius = _radius;
        this.fillColor = _fillColor;
        this.borderColor = _borderColor;
    }

    @Override
    public void getPerimeter() {
        perimeter = Math.PI * 2 * radius;
    }

    @Override
    public void getArea() {
        acreage = Math.PI * (radius * radius);
    }

    @Override
    public void setFillColor() {
        System.out.println("Цвет заливки: " + fillColor);
    }

    @Override
    public void setBorderColor() {
        System.out.println("Цвет границы: " + borderColor);
    }

    public void printCalculations() {
        System.out.println("Периметр круга: " + perimeter);
        System.out.println("Площадь круга: " + acreage);
    }
}
