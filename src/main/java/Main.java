public class Main {

    public static void main(String[] args) {

        // Задание 2, массив из 5 сотрудников
        Employee employee1 = new Employee("Dashanimus", "Corporate Clown", "dashka@clown.ru", "8-800-555-35-35", 0, 23);
        employee1.info();
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("\nIvanov Ivan", "QA-Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        employees[1] = new Employee("Aston Astonov", "Boss", "aston@example.by", "777777777", 99999, 15);
        employees[2] = new Employee("Scott Cowton", "Developer", "fnafer@man.com", "+123456789", 70000, 46);
        employees[3] = new Employee("Michael Jackson", "Designer", "kingof@style.com", "+19582009", 55100, 50);
        employees[4] = new Employee("Olga Buzova", "Manager", "wtfsinger@spb.ru", "+19862001", 10000, 39);

        // Вывод информации о сотрудниках
        for (Employee employee : employees) {
            employee.info();
            System.out.println();
        }
    }
}