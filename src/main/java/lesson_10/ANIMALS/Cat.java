package lesson_10.ANIMALS;

public class Cat extends Animal {
    private static int catCount = 0;

    public Cat(String _name) {
        super(_name);
        catCount++;
    }

    static int getCatCount() {
        return catCount;
    }

    @Override
    public void run(int length) {
        if (length <= 0) {
            System.out.println(name + " не бегал.");
        } else if (length < 201) {
            super.run(length);
        } else {
            System.out.println(name + " не может столько бегать :(");
        }
    }

    @Override
    public void swim(int length) {
        System.out.println(name + " не умеет плавать :(. Он - котик.");
    }
}
