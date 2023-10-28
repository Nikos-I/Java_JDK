package sem4.hw4;

public class Employee {
    int employeeId;
    String phone;
    String name;
    int experience;

    public Employee(int employeeId, String phone, String name, int experience) {
        this.employeeId=employeeId;
        this.phone=phone;
        this.name=name;
        this.experience=experience;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId=employeeId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone=phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience=experience;
    }

    @Override
    public String toString() {
        return String.format("Табельный номер: %d, Имя: %s, Телефон: %s, Стаж: %d", employeeId, name, phone, experience);
    }
}
