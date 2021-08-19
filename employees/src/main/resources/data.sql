DELETE
FROM employees;

INSERT INTO employees(empid, fname, lname, salary)
  VALUES (1, 'Steve', 'Green', 45000)
          (2, 'Liu', 'Wong', 50000)
          (3, 'Ana', 'Trujillo', 75000);

-- Forces the next insert to start its primary key at the selected number
ALTER SEQUENCE hibernate_sequence RESTART WITH 5;