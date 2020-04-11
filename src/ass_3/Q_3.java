/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass_3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Mahmoud Emawi
 */
public class Q_3 {

    public static void main(String args[]) {

        Employee[] employees = {
           new Employee(1, "Ahmad", "IT", 1201),
           new Employee(2, "Sami", "Sales", 950.8),
           new Employee(5, "Huda", "IT",1010.5),
           new Employee(7, "Ali", "Marketing", 1300),
           new Employee(4, "Hani", "Sales", 1050)
           };
           List<Employee> listEmployees = Arrays.asList(employees);
           listEmployees.stream()
           .filter(e-> ( e.getSalary() >=800 && e.getSalary() <1200))
           .map
           (e-> new Employee(e.getId(), e.getName(), e.getDepartment(), e.getSalary()*1.02))
           .collect(Collectors.
           groupingBy(Employee::getDepartment,
           Collectors.counting()))
           .forEach((d, c) -> System.out.println("Dept: "+ d + ", Count: " + c));

    }

    private static class Employee {
        private int id;
        private String name;
        private String department;
        private double salary;

        public Employee(int id, String name, String department, double salaray) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salaray;
        }
        public double getSalary(){
            return salary;
        }
        public String getName(){
            return name;
        }
        public String getDepartment(){
            return department;
        }
        public int getId(){
            return id;
        }
        

    }

}
