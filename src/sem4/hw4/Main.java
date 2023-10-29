package sem4.hw4;

import java.util.ArrayList;
import java.util.List;

import static sem4.hw4.Actions.*;

public class Main {
    public static void main(String[] args) {

        var staff=new ArrayList<Employee>(
                List.of(new Employee(0, "+7 (495) 111-38-24", "Иван", 10)));

        add(staff, "+7 (495) 464-38-24", "Александр", 10);
        add(staff, "+7 (916) 464-38-24", "Владимир", 12);
        add(staff, "+7 (495) 333-38-24", "Василий", 7);
        add(staff, "+7 (495) 444-44-24", "Михаил", 9);
        add(staff, "+7 (495) 555-38-24", "Вера", 8);
        add(staff, "+7 (495) 666-38-24", "Михаил", 15);

        staff.forEach(System.out::println);                // Список сотрудников

        int experience=20;                                 // поиск сотрудника со стажем
        Employee pp=findByExperience(staff, experience);
        if (pp == null)
            System.out.println("нет сотрудника со стажем " + experience);
        else {
            System.out.println("Сотрудник со стажем " + experience + ": " + pp);
        }

        String employeeName = "Михаил";                     // Телефоны сотрудников
        var phonesByName=findPhonesByName(staff, employeeName);
        System.out.println("Телефоны сотрудников по имени " + employeeName + ": " + phonesByName);

        int employeeId = 4;                                 // Поиск сотрудника по табельному номеру
        var idsByName=findSomething(staff, p -> p.getEmployeeId() == employeeId, Employee::getName);
        System.out.println("Табельный номер " + employeeId + " принадлежит: " + idsByName);
    }
}
