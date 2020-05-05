package com.xyzcorp;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Stream;

class Employee {
    private String firstName;
    private String lastName;
    private Integer yearlySalary;

    public Employee(String firstName, String lastName, int yearlySalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearlySalary = yearlySalary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getYearlySalary() {
        return yearlySalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(yearlySalary, employee.yearlySalary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, yearlySalary);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Employee.class.getSimpleName() + "[", "]")
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("yearlySalary=" + yearlySalary)
                .toString();
    }
}

class Manager extends Employee {
    private List<Employee> employeeList;

    public Manager(String firstName, String lastName,
                   int yearlySalary,
                   List<Employee> employeeList) {
        super(firstName, lastName, yearlySalary);
        this.employeeList = employeeList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Objects.equals(employeeList, manager.employeeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), employeeList);
    }
}


public class StreamRunner {
    public static void main(String[] args) {
        var employee1 = new Employee("Natalie", "Schulte", 30000);
        var employee2 = new Employee("Samira", "Ermacora", 40000);
        var employee3 = new Employee("Karsten", "Waller", 50000);
        var employee4 = new Employee("Nikola", "McAfee", 30000);

        var employee5 = new Employee("Mariella", "Ramirez", 35000);
        var employee6 = new Employee("Suhaila", "Mozdzierz", 40000);
        var employee7 = new Employee("Elina", "Lippi", 60000);
        var employee8 = new Employee("Raul", "Gonzales", 31000);

        var manager1 = new Manager("Roxanne", "Russell", 50000, List.of(employee1, employee2, employee3, employee4));
        var manager2 = new Manager("Raja", "Kapoor", 50000, List.of(employee5, employee6, employee7, employee8));

        Stream<Manager> managers = Stream.of(manager1, manager2);
        int result = managers
                           .flatMap(man -> Stream.concat(Stream.of(man), man.getEmployeeList().stream()))
                           .map(Employee::getYearlySalary)
                           .mapToInt(i -> i).sum();
        System.out.println(result);
        Stream<Employee> employeeStream = Stream.of(employee1, employee2,
                employee3, employee4, employee5, employee6, employee7,
                employee8);
        System.out.println(employeeStream.mapToInt(Employee::getYearlySalary).sum());
    }

}
