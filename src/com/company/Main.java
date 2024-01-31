package com.company;
import java.util.*;
abstract class Employee{
    private String name;
    private int id;

    public Employee(String name, int id){
        this.name=name;
        this.id=id;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public abstract double calculateSalary();

    public String toString(){
        return "Employee[Name = "+name+", Id = "+id+ ", Salary = "+calculateSalary()+"]";
    }
}

class fullEmployee extends Employee{
    private int monthlySalary;

    public fullEmployee(String name,int id,int monthlySalary){
        super(name,id);
        this.monthlySalary=monthlySalary;
    }

    public double calculateSalary(){
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{
    private int dailyWorkinghours;
    private int hourSalary;

    public PartTimeEmployee(String name,int id,int dailyWorkinghours,int hourSalary){
        super(name,id);
        this.dailyWorkinghours=dailyWorkinghours;
        this.hourSalary=hourSalary;
    }

    public double calculateSalary(){
        return dailyWorkinghours*hourSalary;
    }
}

class EmployeePayrollSystem{

    private ArrayList<Employee> employeeList;

    public EmployeePayrollSystem(){
        employeeList=new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee removeEmp=null;
        for(Employee emp:employeeList){
            if(emp.getId()==id){
                removeEmp=emp;
                break;
            }
        }
        if(removeEmp!=null){
            employeeList.remove(removeEmp);
        }
    }
    public void displayEmpDetails(){
        for(Employee emp:employeeList){
            System.out.println(emp);
        }
    }
}


public class Main {

    public static void main(String[] args) {
        EmployeePayrollSystem payrollSys = new EmployeePayrollSystem();
        fullEmployee emp1 = new fullEmployee("Daya",1,500000);
        PartTimeEmployee emp2=new PartTimeEmployee("Dayanand",2,5,10000);

        payrollSys.addEmployee(emp1);
        payrollSys.addEmployee(emp2);
        System.out.println("Initial Employee Details");
        payrollSys.displayEmpDetails();
        System.out.println("Removing Employee");
        payrollSys.removeEmployee(2);
        System.out.println("Remaining Employee Details");
        payrollSys.displayEmpDetails();
    }
}
