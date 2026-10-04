package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapProblem {


    public static void main(String[] args) {
        String[] employees = {"Alice", "Bob", "Alice"};
        Integer[] lockers = {101, 102, 103};
        System.out.println(validAssignments(employees, lockers));
    }


    /**
     *
     * Each employee can have only one locker, and each locker can belong to only one employee. Repeating the same assignment is allowed.
     * <p>
     * employees = {"Alice", "Bob", "Alice"};
     * lockers   = {101,     102,   101};
     * <p>
     * // true: Alice consistently uses 101; Bob uses 102.
     * <p>
     * employees = {"Alice", "Bob", "Alice"};
     * lockers   = {101,     102,   103};
     * <p>
     * // false: Alice was assigned 101, then 103.
     * <p>
     * <p>
     * <p>
     * employees = {"Alice", "Bob", "Alice"};
     * lockers   = {101,     102,   103};
     * <p>
     * // false: Alice was assigned 101, then 103.
     * <p>
     * <p>
     * employees = {"Alice", "Bob"};
     * lockers   = {101,     101};
     * <p>
     * // false: locker 101 belongs to Alice, so Bob cannot take it.
     *
     * @return
     */
    public static boolean validAssignments(String[] employees, Integer[] lockers) {
        if (employees.length != lockers.length) {
            return false;
        }

        Map<String, Integer> employeeToLocker = new HashMap<>();
        Map<Integer, String> lockerToEmployee = new HashMap<>();

        for (int i = 0; i < employees.length; i++) {
            String employee = employees[i];
            Integer locker = lockers[i];


            if (employeeToLocker.containsKey(employee) && !Objects.equals(employeeToLocker.get(employee), locker)) {
                return false;
            }


            if (lockerToEmployee.containsKey(locker) && !Objects.equals(lockerToEmployee.get(locker), employee)) {
                return false;
            }

            employeeToLocker.put(employee, locker);
            lockerToEmployee.put(locker, employee);
        }

        return true;
    }


}
