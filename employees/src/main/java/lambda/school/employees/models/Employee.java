package lambda.school.employees.models;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
  @Id //this tells java that next executed line is the primary key
  @GeneratedValue(strategy = GenerationType.AUTO) //tells java that it is a generated value
  private long empid;

  // @Column(nullable = false) //don't neccessarily need unless specified
  private String fname;
  private String lname;
  private double salary;

  public Employee() {
  }

  public Employee(String fname, String lname, double salary) {
    this.fname = fname;
    this.lname = lname;
    this.salary = salary;
  }

  public long getEmpid() {
    return empid;
  }

  public void setEmpid(long empid) {
    this.empid = empid;
  }

  public String getfname() {
    return fname;
  }

  public void setFname(String fname) {
    this.fname = fname;
  }
  
  public String getLname() {
    return lname;
  }

  public void setLname(String lname) {
    this.lname = lname;
  }
  
  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }
}
