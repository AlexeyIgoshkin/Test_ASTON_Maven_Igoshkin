package lesson_3;
import java.math.BigDecimal;
/*
1 ЗАДАНИЕ
1.1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
Конструктор класса должен заполнять эти поля при создании объекта.*/
class Employee {
    private String firstName;
    private String lastName;
    private String position;
    private String email;
    private String phone;
    private BigDecimal salary;
    private int age;
    Employee (String _firstName, String _lastName, String _position, String _email, String _phone, BigDecimal _salary, int _age) {
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.position = _position;
        this.email = _email;
        this.phone = _phone;
        this.salary = _salary;
        this.age = _age;

        //Метод с текстом при создании сотрудника
        comparisonSalary();
    }

//1.2. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
    public void employeeInfo() {
        System.out.println("Имя: " + firstName);
        System.out.println("Фамилия: " + lastName);
        System.out.println("Должность: " + position);
        System.out.println("Email: " + email);
        System.out.println("Телефон: " + phone);
        System.out.println("Зарплата: " + salary + " руб.");
        System.out.println("Возраст: " + age + " лет");
        System.out.println();
    }

    // Текст при создании сотрудника с условием
    public void comparisonSalary () {
        BigDecimal subSalary;
        BigDecimal mySalary = new BigDecimal("100000");
        if (salary.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println(position + " " + firstName + " " + lastName + " успешно добавлен в штат с отрицательной зарплатой, вот это да!");
        } else if (salary.compareTo(BigDecimal.ZERO) == 0) {
            System.out.println(position + " " + firstName + " " + lastName + " успешно добавлен в штат и работает за еду!");
        } else if (salary.compareTo(mySalary) < 0) {
            subSalary = mySalary.subtract(salary);
            System.out.println(position + " " + firstName + " " + lastName + " успешно добавлен в штат. " + firstName + " зарабатывает меньше тебя на " + subSalary + " рублей!");
        } else if (salary.compareTo(mySalary) > 0) {
            subSalary = salary.subtract(mySalary);
            System.out.println(position + " " + firstName + " " + lastName + " успешно добавлен в штат. " + firstName + " зарабатывает больше тебя на " + subSalary + " рублей!");
        } else {
            System.out.println(position + " " + firstName + " " + lastName + " успешно добавлен в штат. " + firstName + " зарабатывает те же " + mySalary + " рублей, что и ты!");
        }

    }


// 2 ЗАДАНИЕ.
// Создать массив из 5 сотрудников.
    public static Employee[] empArray() {
        Employee[] peersArray = new Employee[5];
        peersArray[0] = new Employee("Александр", "Царев","Директор","director@gmail.com", "89002567121", new BigDecimal("300000"), 51);
        peersArray[1] = new Employee("Михаил", "Снеговой","Менеджер","manager@gmail.com", "89002839584", new BigDecimal("100000"),33);
        peersArray[2] = new Employee("Елена", "Васильева","HR","hr@gmail.com", "89003402952", new BigDecimal("60000"),29);
        peersArray[3] = new Employee("Виктор", "Абрусов","Программист","programmer@gmail.com", "89001927485", new BigDecimal("0"),27);
        peersArray[4] = new Employee("Ольга", "Орлова","QA-инженер","qa@gmail.com", "89001129421", new BigDecimal("-200000"),23);
    return peersArray;
    }
}
