package Lesson7;

public class Plate {
    private int food;
    private int initialFood;

    public Plate(int food) {
        this.food = food;
        this.initialFood = food;
    }

    public void info() {
        System.out.println("Еды в миске: " + food);
    }

    public void increaseFood(int amount) {
        if ((food + amount) > initialFood) {
            System.out.println("В миску так много не поместиться, не удается пополнить миску!");
        } else {
            food += amount;
            System.out.printf("В миске теперь %d еды\n", food);
        }
    }

    public boolean decreaseFood(int amount) {
        if (!checkFood(amount)) {
            food -= amount;
            return true;
        }
        return false;
    }
    public boolean checkFood(int amount) {
        boolean res = (food - amount <= 0) || food < amount;
        if ( res ) System.out.println("В миске недостаточно корма, необходимо добавить еды!");
        return res;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }
}
