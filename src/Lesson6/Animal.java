package Lesson6;

public class Animal {

    protected final String name;
    public Animal(String name) {
        this.name = name;
    }

    public void run(int distance, int runLimit) {
        String result1 = String.format("%s пробежал %d метров", this.name, distance);
        String result2 = String.format("%s не смог пробежать %d метров", this.name, distance);

        if (distance <= runLimit) {
            System.out.println(result1);
        } else  System.out.println(result2);
    }

    public void swim(int distance, int swimLimit) {
        String result1 = String.format("%s проплыл %d метров", this.name, distance);
        String result2 = String.format("%s не смог проплыть %d метров", this.name, distance);

        if (distance <= swimLimit) {
            System.out.println(result1);
        } else  System.out.println(result2);
    }
}
