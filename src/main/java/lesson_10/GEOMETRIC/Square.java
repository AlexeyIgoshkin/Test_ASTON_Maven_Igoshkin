package lesson_10.GEOMETRIC;

public class Square extends GeometricFigure implements GeometricInterface {
    public Square(double _side, String _fillColor, String _borderColor) {
        this.side = _side;
        this.fillColor = _fillColor;
        this.borderColor = _borderColor;
    }
    @Override
    public void mathCalculation() {
        double perimeter = side * 4;
        System.out.println("Периметр квадрата: " + perimeter);
        double acreage = side * side;
        System.out.println("Площадь квадрата: " + acreage);
    }

    @Override
    public void colors () {
        System.out.println("Цвет заливки: " + fillColor);
        System.out.println("Цвет границы: " + borderColor);
    }
}


