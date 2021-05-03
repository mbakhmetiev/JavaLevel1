package Lesson5;

public class Employee {
    private String name;
    private String surname;
    private String role;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee(String name, String surname, String role, String email, String phone, int salary, int age) {
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void employeeData() {
        System.out.printf("Name: %8s | Surname: %8s | Role: %35s | Email: %32s | Phone: %10s | Salary: %6d | Age: %2d\n", name, surname, role, email, phone, salary, age);
    }

    public int getAge () {
        return age;
    }
}
