package sorting_emp;

import java.util.*;


class Employee implements Comparable<Employee>, Cloneable {
 private int id;
 private String name;
 private double salary;

 
 public Employee(int id, String name, double salary) {
     this.id = id;
     this.name = name;
     this.salary = salary;
 }


 public int getId() {
     return id;
 }

 public String getName() {
     return name;
 }

 public double getSalary() {
     return salary;
 }

 @Override
 public int compareTo(Employee other) {
     return Integer.compare(this.id, other.id);
 }

 
 @Override
 protected Object clone() throws CloneNotSupportedException {
     return super.clone();
 }

 
 @Override
 public String toString() {
     return "Employee [ID=" + id + ", Name=" + name + ", Salary=" + salary + "]";
 }
}


class EmployeeComparators {
 
 public static Comparator<Employee> compareByName() {
     return new Comparator<Employee>() {
         @Override
         public int compare(Employee e1, Employee e2) {
             return e1.getName().compareTo(e2.getName());
         }
     };
 }


 public static Comparator<Employee> compareBySalary() {
     return new Comparator<Employee>() {
         @Override
         public int compare(Employee e1, Employee e2) {
             return Double.compare(e1.getSalary(), e2.getSalary());
         }
     };
 }
}

class EmployeeManager implements Iterable<Employee> {
 private List<Employee> employeeList;

 
 public EmployeeManager() {
     employeeList = new ArrayList<>();
 }


 public void addEmployee(Employee e) {
     employeeList.add(e);
 }

 
 public void sortById() {
     Collections.sort(employeeList);
 }

 
 public void sortByName() {
     Collections.sort(employeeList, EmployeeComparators.compareByName());
 }

 
 public void sortBySalary() {
     Collections.sort(employeeList, EmployeeComparators.compareBySalary());
 }

 
 public void printEmployees() {
     for (Employee e : employeeList) {
         System.out.println(e);
     }
 }

 
 @Override
 public Iterator<Employee> iterator() {
     return employeeList.iterator();
 }

 
 public static void main(String[] args) throws CloneNotSupportedException {
     EmployeeManager manager = new EmployeeManager();

     
     manager.addEmployee(new Employee(101, "sunny", 50000));
     manager.addEmployee(new Employee(102, "rahul", 60000));
     manager.addEmployee(new Employee(103, "varun", 40000));

     
     System.out.println("Employees (Sorted by ID):");
     manager.sortById();
     manager.printEmployees();

     
     System.out.println("\nEmployees (Sorted by Name):");
     manager.sortByName();
     manager.printEmployees();

     
     System.out.println("\nEmployees (Sorted by Salary):");
     manager.sortBySalary();
     manager.printEmployees();

     
     Employee original = new Employee(104, "Mark", 55000);
     Employee clone = (Employee) original.clone();
     System.out.println("\nOriginal Employee: " + original);
     System.out.println("Cloned Employee: " + clone);
 }
}
