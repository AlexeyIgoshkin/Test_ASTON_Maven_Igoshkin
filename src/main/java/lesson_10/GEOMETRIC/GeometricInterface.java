package lesson_10.GEOMETRIC;

public interface GeometricInterface {
    // Объединил методы по математическим вычислениям и цветам. Менее гибко, чем отдельно, но принцип интерфейса понятен
    void mathCalculation();
    void colors();

    // Добавил те же вычисления через дефолтный метод квадрату
    default void perimeterSquare() {
        double side = 5;
        double perimeter = side * 4;
        System.out.println("Периметр квадрата: " + perimeter);
    }

    default void acreageSquare() {
        double side = 5;
        double acreage = side * side;
        System.out.println("Периметр квадрата: " + acreage);
    }
}
