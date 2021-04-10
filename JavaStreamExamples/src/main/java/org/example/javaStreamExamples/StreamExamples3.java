package org.example.javaStreamExamples;

import java.util.ArrayList;
import java.util.List;

public class StreamExamples3 {

    public static class Employee {
        public String salary;

        public Employee(String salary) {
            this.salary = salary;
        }
    }

    public static void main(String[] args) {

        List<Employee> list = new ArrayList<>();
        list.add(new Employee("100000"));
        list.add(new Employee("200000"));
        list.add(new Employee("250000"));

        int sum = list.stream()
                .map(employee -> employee.salary)
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);

        System.out.println(sum);

    }
}
