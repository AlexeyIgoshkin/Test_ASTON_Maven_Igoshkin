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

        Park.Attraction Attraction1 = new Park.Attraction("'Колесо обозрения'", "10:00-21:00", 600);
        Park.Attraction Attraction2 = new Park.Attraction("'Молот'", 1000);
        Park.Attraction Attraction3 = new Park.Attraction("'Трюк'");
        Park.Attraction Attraction4 = new Park.Attraction("'Ромашка'","12:00-20:00");

        System.out.println("\nИНФОРМАЦИЯ О СОТРУДНИКАХ");
        employee1.employeeInfo();
        employee2.employeeInfo();
        employee3.employeeInfo();
        employee4.employeeInfo();
        employee5.employeeInfo();

        System.out.println("\nИНФОРМАЦИЯ ОБ АТТРАКЦИОНАХ");
        Attraction1.AttractionInfo();
        Attraction2.AttractionInfo();
        Attraction3.AttractionInfo();
        Attraction4.AttractionInfo();

    }
}
