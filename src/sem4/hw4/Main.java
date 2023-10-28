package sem4.hw4;

import java.util.ArrayList;
import java.util.List;

import static sem4.hw4.Actions.*;

public class Main {
    public static void main(String[] args) {

        var staff = new ArrayList<Employee>(
                List.of(new Employee(0, "+7 (495) 111-38-24", "Иван", 10)));

        add(staff, "+7 (495) 464-38-24", "Александр", 10);
        add(staff, "+7 (916) 464-38-24", "Владимир", 12);
        add(staff, "+7 (495) 333-38-24", "Василий", 7);
        add(staff, "+7 (495) 444-44-24", "Михаил", 9);
        add(staff, "+7 (495) 555-38-24", "Вера", 8);
        add(staff, "+7 (495) 666-38-24", "Александра", 15);

        System.out.println("Сотрудник со стажем 8:" + findByExperience(staff, 8));
        Employee pp=findByExperience(staff, 20);
        if (pp == null) {
            System.out.println("нет такого");

        } else {
            System.out.println("Сотрудник со стажем 20:" + pp);
        }

        staff.forEach(System.out::println);

        var phonesByName=findPhonesByName(staff, "Михаил");
        System.out.println("Сотрудники по имени Михаил : " + phonesByName);

        var idsByName=findSomething(staff, p -> p.getName() == "Владимир", p -> p.getEmployeeId());
        System.out.println("ID Владимира: " + idsByName);
    }
}
