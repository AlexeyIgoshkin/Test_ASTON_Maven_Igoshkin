package lesson_3;

public class Main {
    public static void main(String[] args) {
        System.out.println();

        Employee[] persArray = Employee.empArray();
        Employee employee1 = persArray[0];
        Employee employee2 = persArray[1];
        Employee employee3 = persArray[2];
        Employee employee4 = persArray[3];
        Employee employee5 = persArray[4];

        Park.Schedule schedule1 = new Park.Schedule("'Колесо обозрения'", "10:00-21:00", 600);
        Park.Schedule schedule2 = new Park.Schedule("'Молот'", 1000);
        Park.Schedule schedule3 = new Park.Schedule("'Трюк'");
        Park.Schedule schedule4 = new Park.Schedule("'Ромашка'","12:00-20:00");

        System.out.println("\nИНФОРМАЦИЯ О СОТРУДНИКАХ");
        employee1.employeeInfo();
        employee2.employeeInfo();
        employee3.employeeInfo();
        employee4.employeeInfo();
        employee5.employeeInfo();

        System.out.println("\nИНФОРМАЦИЯ ОБ АТТРАКЦИОНАХ");
        schedule1.scheduleInfo();
        schedule2.scheduleInfo();
        schedule3.scheduleInfo();
        schedule4.scheduleInfo();

    }
}
