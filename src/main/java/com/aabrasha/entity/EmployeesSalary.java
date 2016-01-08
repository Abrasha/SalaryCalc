package com.aabrasha.entity;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.math.BigDecimal;

/**
 * Created by Abrasha on 07-Jan-16.
 */
public class EmployeesSalary {

    private ObjectProperty<Employee> forEmployee = new SimpleObjectProperty<>();
    private ObjectProperty<BigDecimal> rateSalary = new SimpleObjectProperty<>();



    public EmployeesSalary(){
    }



    public EmployeesSalary(Employee forEmployee, BigDecimal rateSalary){
        this.forEmployee.set(forEmployee);
        this.rateSalary.set(rateSalary);
    }



    public Employee getForEmployee(){
        return forEmployee.get();
    }



    public void setForEmployee(Employee forEmployee){
        this.forEmployee.set(forEmployee);
    }



    public ObjectProperty<Employee> forEmployeeProperty(){
        return forEmployee;
    }



    public BigDecimal getRateSalary(){
        return rateSalary.get();
    }



    public void setRateSalary(BigDecimal rateSalary){
        this.rateSalary.set(rateSalary);
    }



    public ObjectProperty<BigDecimal> rateSalaryProperty(){
        return rateSalary;
    }
}
