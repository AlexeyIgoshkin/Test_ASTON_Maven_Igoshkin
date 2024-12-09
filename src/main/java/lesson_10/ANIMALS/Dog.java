package lesson_10.ANIMALS;

public class Dog extends Animal {
    private static int dogCount = 0;
    public Dog(String _name) {
        super(_name);
        dogCount++;
    }

    static int getDogCount() {
        return dogCount;
    }

    @Override
    public void run(int length) {
        if (length <= 0) {
            System.out.println(name + " не бегал.");
        } else if (length < 501) {
            super.run(length);
        } else {
            System.out.println(name + " не может столько бегать :(");
        }
    }

    @Override
    public void swim(int length) {
        if (length <= 0) {
            System.out.println(name + " не плыл.");
        } else if (length < 11) {
            super.swim(length);
        } else {
            System.out.println(name + " не может столько плыть :(");
        }
    }
}
