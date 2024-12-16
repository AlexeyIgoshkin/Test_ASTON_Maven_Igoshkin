package lesson_10.GEOMETRIC;

public class Square extends GeometricFigure implements GeometricInterface {
    double perimeter;
    double acreage;
    public Square(double _side, String _fillColor, String _borderColor) {
        this.side = _side;
        this.fillColor = _fillColor;
        this.borderColor = _borderColor;
    }

    @Override
    public void getPerimeter() {
        perimeter = side * 4;
    }

    @Override
    public void getArea() {
        acreage = side * side;
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
        System.out.println("Периметр квадрата: " + perimeter);
        System.out.println("Площадь квадрата: " + acreage);
    }
}


