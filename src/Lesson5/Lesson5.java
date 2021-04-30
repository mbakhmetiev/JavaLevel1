package Lesson5;

public class Lesson5 {

    public static void main(String[] args) {

        Employee[] employee = new Employee[5];
        String[][] names = {{"Ellen", "Ripley"},{"Carter", "Burke"},{"Dwayne", "Hicks"},{"William", "Hudson"},{"Scott", "Gorman"}};
        String[] roles = {"Nostromo warrant officer","Special projects director", "Colonial Marines corporal", "Colonial Marines private", "Colonial Marines commanding officer" };
        String[] email = {"ellen.ripley@wayland-yutani.com", "carter.bruke@wayland-yutani.com", "dwayne.hicks@uscmc.com","william.hudson@uscmc.com","scott.gorman@uscmc.com" };
        String[] phone = {"345-8987-92","345-8987-73","345-8987-15","345-8987-07","345-8987-01"};
        int[] salary = {246765,446500,234200,234100,214200};
        int[] age = {95,41,31,35,29};

        for (int i = 0; i < names.length; i++) {
            employee[i] = new Employee(names[i][0], names[i][1], roles[i], email[i], phone[i], salary[i], age[i]);
        }
        System.out.println("************************************************ Sulaco crew ************************************************");
        for( Employee person : employee) {
            person.employeeData();
        }

        System.out.println("************************************** Crew members aged above 40 *******************************************");
        for( Employee person : employee) {
            if (person.getAge() > 40) person.employeeData();
        }
    }
}
