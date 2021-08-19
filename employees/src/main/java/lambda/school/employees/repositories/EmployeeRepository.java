package lambda.school.employees.repositories;

import org.springframework.data.repository.CrudRepository;
import lambda.school.employees.models.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
  
}
