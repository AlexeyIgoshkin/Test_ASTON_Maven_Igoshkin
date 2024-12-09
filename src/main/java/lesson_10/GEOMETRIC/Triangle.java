package lesson_10.GEOMETRIC;

public class Triangle extends GeometricFigure implements GeometricInterface {
    public Triangle(double _sideA, double _sideB, double _sideC, String _fillColor, String _borderColor) {
        this.sideA = _sideA;
        this.sideB = _sideB;
        this.sideC = _sideC;
        this.fillColor = _fillColor;
        this.borderColor = _borderColor;
    }
    @Override
    public void mathCalculation() {
        double perimeter = sideA + sideB + sideC;
        System.out.println("Периметр треугольника: " + perimeter);
        double p = perimeter / 2;
        double acreage = Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
        System.out.println("Площадь треугольника: " + acreage);
    }
    @Override
    public void colors() {
        System.out.println("Цвет заливки: " + fillColor);
        System.out.println("Цвет границы: " + borderColor);
    }
}