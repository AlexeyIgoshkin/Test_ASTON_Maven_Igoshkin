package lesson_10.GEOMETRIC;

public class GeometricFigure {
    private double radius;
    private double side;
    private double pi = 3.14;
    private double side1, side2, side3;
    public GeometricFigure(){}
    public GeometricFigure(double _border) {
        this.side = _border;
    }

    public GeometricFigure(double _side1, double _side2, double _side3) {
        this.side1 = _side1;
        this.side2 = _side2;
        this.side3 = _side3;
    }
    public GeometricFigure(double _radius, double pi) {
        this.radius = _radius;
    }
}