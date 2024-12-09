package lesson_10.ANIMALS;

public class Animal {
    private boolean isFull;
    private static int animalCount = 0;
    String name;

    public Animal(String _name){
        this.isFull = false;
        this.name = _name;
        animalCount++;
    }

    static int getAnimalCount() {
        return animalCount;
    }

    public void run(int length) {
        System.out.println(name + " пробежал " + length + " метров.");
    }

    public void swim(int length) {
        System.out.println(name + " проплыл " + length + " метров.");
    }

    public void eat(int mealAmount, int desiredAmount) {
        int mealLeft = mealAmount - desiredAmount;
        int mealMissed = desiredAmount - mealAmount;
        if (mealAmount < desiredAmount) {
            System.out.println(name + " не поел. Он хотел " + desiredAmount + " единицы пищи, ему не хватило " + mealMissed +".");
        } else if (mealAmount == desiredAmount) {
            isFull = true;
            System.out.println(name + " поел. В миске не осталось еды.");
        }else {
            isFull = true;
            System.out.println(name + " поел. В миске осталось " + mealLeft + " единиц еды. ");
        }
    }

    public void isSatisfied() {
        if (isFull) {
            System.out.println(name + " сыт. ");
        } else {
            System.out.println(name + " голоден. ");
        }
    }
}





