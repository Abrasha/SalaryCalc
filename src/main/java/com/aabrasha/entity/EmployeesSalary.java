package com.aabrasha.entity;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * Created by Abrasha on 07-Jan-16.
 */
public class EmployeesSalary {

    private ObjectProperty<Employee> forEmployee = new SimpleObjectProperty<>();
    private DoubleProperty rateSalary = new SimpleDoubleProperty();



    public EmployeesSalary(){
    }



    public EmployeesSalary(Employee forEmployee, double rateSalary){
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



    public double getRateSalary(){
        return rateSalary.get();
    }



    public void setRateSalary(double rateSalary){
        this.rateSalary.set(rateSalary);
    }



    public DoubleProperty rateSalaryProperty(){
        return rateSalary;
    }
}
