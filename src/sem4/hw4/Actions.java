package sem4.hw4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Actions {
    static Employee findByExperience(List<Employee> list, int experience) {
        assert list != null : "LIST";
        var opt = list.stream().filter(p -> p.getExperience() == experience).findAny();
        return opt.orElse(null);
    }

    static List<String> findPhonesByName(List<Employee> list, String name) {
        return list.stream().filter(p -> p.getName().equalsIgnoreCase(name))
                .map(Employee::getPhone).toList();
    }

    static <R> List<R> findSomething(List<Employee> list, Predicate<Employee> filter, Function<Employee, R> mapper) {
        return list.stream().filter(filter).map(mapper).toList();
    }

    static void add(ArrayList<Employee> list, String phone, String name, int experience) {
        int nextId = 0;
        if (list != null) {
            nextId = list.stream().mapToInt(Employee::getEmployeeId).max().getAsInt()+1;
        }
        list.add(new Employee(nextId, phone, name, experience));
    }

}
