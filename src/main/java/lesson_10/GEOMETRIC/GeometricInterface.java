package lesson_10.GEOMETRIC;

public interface GeometricInterface {
    // Объединил методы по математическим вычислениям и цветам. Менее гибко, чем отдельно, но принцип интерфейса понятен
    void getPerimeter();
    void getArea();
    void setFillColor();
    void setBorderColor();

    // Добавил те же вычисления через дефолтный метод квадрату
    default void fillColor(String fillColor) {
        System.out.println("Цвет заливки фигуры: " + fillColor);
    }

    default void backgroundColor(String backgroundColor) {
        System.out.println("Цвет границы фигуры: " + backgroundColor);
    }
}
