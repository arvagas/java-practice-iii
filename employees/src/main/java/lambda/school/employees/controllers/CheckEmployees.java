package lambda.school.employees.controllers;

import lambda.school.employees.models.Employee;

@FunctionalInterface
public interface CheckEmployees {
  boolean test(Employee employee);
}
