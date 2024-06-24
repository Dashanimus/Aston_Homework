public class Employee {

    private final String fullName;
    private final String position;
    private final String email;
    private final String phone;
    private final double salary;
    private final int age;

    // Конструктор принимающий все поля класса
    public Employee(String fullName, String position, String email, String phone, double salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
    public void info() {
        System.out.println("Name: "+fullName+" | Position: "+position+" | email: "+email+" | Phone: "+phone+" | Salary: "+salary+" | Age: "+age);
    }

}