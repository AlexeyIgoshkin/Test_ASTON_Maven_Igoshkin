package lesson_10.GEOMETRIC;

public interface GeometricInterface {
    void getPerimeter();
    void getArea();
    void setFillColor();
    void setBorderColor();

    default void fillColor(String fillColor) {
        System.out.println("Цвет заливки фигуры: " + fillColor);
    }

    default void backgroundColor(String backgroundColor) {
        System.out.println("Цвет границы фигуры: " + backgroundColor);
    }
}
