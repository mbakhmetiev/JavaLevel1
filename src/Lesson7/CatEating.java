package Lesson7;

public class CatEating {
    public static void main(String[] args) {
        Cat[] cats = {new Cat("Цезарь", 25), new Cat("Ганнибал", 18), new Cat("Атилла", 23),
                new Cat("Тамерлан", 33), new Cat("Александр", 17)};
        Plate plate = new Plate(100);
        plate.info();
        System.out.println("********************** Первый раунд кормления ***************************");
        for (Cat cat : cats) {
            cat.eat(plate);
            plate.info();
            System.out.println("---------");
        }
        System.out.println("********************** Второй раунд кормления ***************************");
        for (Cat cat : cats) {
            cat.eat(plate);
            plate.info();
            System.out.println("---------");
        }
    }
}
