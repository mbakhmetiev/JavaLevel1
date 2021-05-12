package Lesson6;

import java.util.Random;

public class Main {

    static int animalCount = 0;
    static int dogCount = 0;
    static int catCount = 0;

    public static void main(String[] args) {
       String[] dogNames = {"Цезарь", "Александр", "Навуходоносор", "Атилла","Ганнибал", "Шарлемань"};
       String[] catNames = {"Афина","Диметра","Гестия","Гера","Персефона"};
       Random rand = new Random();

        System.out.println("********** Состязаниe пёсиков ***********");

       for (int i = 0; i < dogNames.length ; i++) {
           Dog dog = new Dog(dogNames[i]);
           dog.run(rand.nextInt(900), dog.RUNLIMIT );
           dog.swim(rand.nextInt(20), dog.SWIMLIMIT );
           animalCount(dog);
           System.out.println();
       }

       System.out.println("********** Состязаниe котиков ***********");

       for (int i = 0; i < catNames.length; i++) {
            Cat cat = new Cat(catNames[i]);
            cat.run(rand.nextInt(600), cat.RUNLIMIT );
            cat.swim(rand.nextInt(20), cat.SWIMLIMIT );
            animalCount(cat);
           System.out.println();
        }
        System.out.println("******************************************");
        System.out.println("Собак участвовало: " + dogCount);
        System.out.println("Котов участвовало: " + catCount);
        System.out.println("Всего животных участвовало: " + animalCount);
    }

    static void animalCount(Animal animal) {
        if (animal instanceof Dog) dogCount++;
        if (animal instanceof Cat) catCount++;
        animalCount++;
    }
}
