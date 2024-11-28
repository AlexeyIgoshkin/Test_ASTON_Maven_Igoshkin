package lesson_3;

/*
1 ЗАДАНИЕ
1.1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
Конструктор класса должен заполнять эти поля при создании объекта.*/
class Employee {
    String name;
    String position;
    String email;
    String phone;
    int salary;
    int age;
    Employee (String _name, String _position, String _email, String _phone, int _salary, int _age) {
        this.name = _name;
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
        System.out.println("ФИО: " + name);
        System.out.println("Должность: " + position);
        System.out.println("Email: " + email);
        System.out.println("Телефон: " + phone);
        System.out.println("Зарплата: " + salary + " руб.");
        System.out.println("Возраст: " + age + " лет");
        System.out.println();
    }

    // Текст при создании сотрудника с условием
    public void comparisonSalary () {
        int subSalary;
        int mySalary = 100000;
        if (salary < 0) {
            System.out.println(position + " " + name + " успешно добавлен в штат с отрицательной зарплатой, вот это да!");
        } else if (salary == 0) {
            System.out.println(position + " " + name + " успешно добавлен в штат и работает за еду!");
        } else if (salary < mySalary) {
            subSalary = mySalary - salary;
            System.out.println(position + " " + name + " успешно добавлен в штат. " + name + " зарабатывает меньше тебя на " + subSalary + " рублей!");
        } else if (salary > mySalary) {
            subSalary = salary - mySalary;
            System.out.println(position + " " + name + " успешно добавлен в штат. " + name + " зарабатывает больше тебя на " + subSalary + " рублей!");
        } else {
            System.out.println(position + " " + name + " успешно добавлен в штат. " + name + " зарабатывает те же " + mySalary + " рублей, что и ты!");
        }

    }


// 2 ЗАДАНИЕ.
// Создать массив из 5 сотрудников.
    public static Employee[] empArray() {
        Employee[] persArray = new Employee[5];
        persArray[0] = new Employee("Александр", "Директор","director@gmail.com","89002567121", 300000,51);
        persArray[1] = new Employee("Михаил", "Менеджер","manager@gmail.com","89002839584", 100000,33);
        persArray[2] = new Employee("Елена", "HR","hr@gmail.com","89003402952", 60000,29);
        persArray[3] = new Employee("Виктор", "Программист","programmer@gmail.com","89001927485", 0,27);
        persArray[4] = new Employee("Ольга", "QA-инженер","qa@gmail.com","89001129421", -200000,23);
    return persArray;
    }
}
