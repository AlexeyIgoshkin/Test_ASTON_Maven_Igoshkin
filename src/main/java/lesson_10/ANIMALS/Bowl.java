package lesson_10.ANIMALS;

public class Bowl {
    private int bowlFood;
    public Bowl(int foodAmount) {
        this.bowlFood = foodAmount;
    }

    public int getFoodAmount() {
        return bowlFood;
    }

    public void addFood(int amount) {
        if (amount > 0) {
            bowlFood += amount;
            System.out.println("Хозяин добавил " + amount + " единиц еды в миску.");
        } else {
            System.out.println("Отнять у котиков еду нельзя.");
        }
    }

    public void removeFood(int amount) {
        if (amount > 0 && bowlFood > amount) {
            bowlFood -= amount;
            System.out.println("Он съел " + amount + " единиц еды из миски.");
        }
        else {
            System.out.println("\u001B[31mЕда закончилась\u001B[0m");
        }
        System.out.println();
    }
}