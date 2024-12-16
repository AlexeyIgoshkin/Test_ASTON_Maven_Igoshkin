package lesson_10.GEOMETRIC;

public class Triangle extends GeometricFigure implements GeometricInterface {
    double perimeter;
    double acreage;
    public Triangle(double _sideA, double _sideB, double _sideC, String _fillColor, String _borderColor) {
        this.sideA = _sideA;
        this.sideB = _sideB;
        this.sideC = _sideC;
        this.fillColor = _fillColor;
        this.borderColor = _borderColor;
    }

    @Override
    public void getPerimeter() {
        perimeter = sideA + sideB + sideC;
    }

    @Override
    public void getArea() {
        perimeter = sideA + sideB + sideC;
        double p = perimeter / 2;
        acreage = Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
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
        System.out.println("Периметр треугольника: " + perimeter);
        System.out.println("Площадь треугольника: " + acreage);
    }
}