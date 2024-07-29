package model;

public class Employee {
    private int empId;
    private String empName;
    private String grade;
    private double salary;
    private String empDepartment;

    public Employee(int empId, String empName, String grade, double salary, String empDepartment) {
        this.empId = empId;
        this.empName = empName;
        this.grade = grade;
        this.salary = salary;
        this.empDepartment = empDepartment;
    }

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getGrade() {
        return grade;
    }

    public double getSalary() {
        return salary;
    }

    public String getEmpDepartment() {
        return empDepartment;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", grade='" + grade + '\'' +
                ", salary=" + salary +
                ", empDepartment='" + empDepartment + '\'' +
                '}';
    }
}
