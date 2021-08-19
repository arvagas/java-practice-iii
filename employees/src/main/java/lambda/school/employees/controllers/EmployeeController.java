package lambda.school.employees.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lambda.school.employees.models.Employee;
import lambda.school.employees.repositories.EmployeeRepository;

//this is what the client will talk with
@RestController
public class EmployeeController {

  //in order to use repo methods, you need to have instance that can call it
  //Autowired allows the use of said repo methods
  @Autowired
  private EmployeeRepository employeeRepository;

  @GetMapping(value = "/employees/all", produces = "application/json")
  public ResponseEntity<?> findAllEmployees() {
    List<Employee> employees = new ArrayList<>();

    employeeRepository.findAll().iterator().forEachRemaining(e -> employees.add(e));

    return new ResponseEntity<>(employees, HttpStatus.OK);
  }
  
  @GetMapping(value = "/employees/total", produces = "application/json")
  public ResponseEntity<?> getTotal() {
    List<Employee> employees = new ArrayList<>();

    employeeRepository.findAll().iterator().forEachRemaining(e -> employees.add(e));

    double total = 0.0;
    for (Employee e : employees) {
      total += e.getSalary();
    }

    System.out.println("The total is: " + total);

    return new ResponseEntity<>(total, HttpStatus.OK);
  }

  @GetMapping(value = "/employees/name/{letter}", produces = "application/json")
  public ResponseEntity<?> findByName(@PathVariable char letter) {
    List<Employee> employees = new ArrayList<>();

    employeeRepository.findAll().iterator().forEachRemaining(e -> employees.add(e));

    List<Employee> filteredList = filterEmployees(employees,
                                  (e) -> e.getfname().charAt(0) == letter);

    return new ResponseEntity<>(filteredList, HttpStatus.OK);
  }

  private List<Employee> filterEmployees(List<Employee> employeeList, CheckEmployees tester) {
    List<Employee> rtnList = new ArrayList<>();

    for(Employee e : employeeList) {
      if (tester.test(e)) {
        rtnList.add(e);
      }
    }

    return rtnList;
  }
}
