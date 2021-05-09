package Lesson7;

import java.util.Random;

public class Cat {
    private String name;
    private int appetite;
    private boolean hungry;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.hungry = true;
    }

    public void eat(Plate p) {
        Random rand = new Random();
        int addfood;
        System.out.printf("---> %s пробует поесть\n", name);
        if (!hungry) {
            System.out.println("Кот уже сыт и есть не хочет");
        }
        else if (hungry && p.decreaseFood(appetite)) {
            System.out.printf("Котик насытился, употребив %d еды\n", appetite);
            hungry = false;
            }
        else {
            System.out.println("Кот не смог нормально перекусить :((( ");
            addfood = rand.nextInt(100);
            System.out.println("Попробуем доложить еды в миску " + addfood);
            p.increaseFood(addfood);
            if (hungry && p.decreaseFood(appetite)) {
                System.out.printf("Котик наконец-то сыт, он cьел %d еды:\n", appetite);
            hungry = false;
            }
            else System.out.println("Поесть так и не удалось :(");
        }
    }
}
