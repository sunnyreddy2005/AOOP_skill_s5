package api;

import java.util.*;
import java.util.stream.*;

class Employee {
    private String name;
    private double salary;
    private String department;

    public Employee(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', salary=" + salary + ", department='" + department + "'}";
    }
}

public class main {
    public static void main(String[] args) {
        
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 75000, "HR"),
            new Employee("Bob", 50000, "IT"),
            new Employee("Charlie", 85000, "Finance"),
            new Employee("David", 55000, "IT"),
            new Employee("Eve", 90000, "Finance"),
            new Employee("Frank", 65000, "HR"),
            new Employee("Grace", 70000, "Finance"),
            new Employee("Hank", 95000, "HR"),
            new Employee("Ivy", 60000, "IT"),
            new Employee("Jack", 80000, "Finance")
        );

        
        System.out.println("Employees with salary > 60,000:");
        employees.stream()
            .filter(e -> e.getSalary() > 60000) 
            .forEach(System.out::println); 

       
        System.out.println("\nEmployees sorted by salary:");
        employees.stream()
            .sorted(Comparator.comparingDouble(Employee::getSalary)) 
            .forEach(System.out::println);

       
        System.out.println("\nEmployee with the highest salary:");
        Employee highestSalaryEmployee = employees.stream()
            .max(Comparator.comparingDouble(Employee::getSalary)) 
            .orElseThrow(NoSuchElementException::new);
        System.out.println(highestSalaryEmployee);

        
        System.out.println("\nAverage salary of employees:");
        double averageSalary = employees.stream()
            .mapToDouble(Employee::getSalary) 
            .average() 
            .orElse(0.0);
        System.out.println(averageSalary);
    }
}
