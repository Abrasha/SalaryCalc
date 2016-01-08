package com.aabrasha.entity.reports.monthly.salary;

import com.aabrasha.entity.EmployeesSalary;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.math.BigDecimal;

/**
 * Created by Abrasha on 07-Jan-16.
 */
public class PaymentEntry {

    // TODO define all values as DoubleProperty

    private ObjectProperty<EmployeesSalary> employeesSalary = new SimpleObjectProperty<>();
    private DoubleProperty pieceSalary = new SimpleDoubleProperty();
    private DoubleProperty otherSalary = new SimpleDoubleProperty();
    private DoubleProperty togetherSalary = new SimpleDoubleProperty();
    private DoubleProperty firstPartSalary = new SimpleDoubleProperty();
    private DoubleProperty esvTax = new SimpleDoubleProperty();
    private DoubleProperty incomeTax = new SimpleDoubleProperty();
    private DoubleProperty militaryTax = new SimpleDoubleProperty();
    private DoubleProperty togetherTax = new SimpleDoubleProperty();
    private DoubleProperty totalToPay = new SimpleDoubleProperty();



    public PaymentEntry(EmployeesSalary employeesSalary, BigDecimal pieceSalary, BigDecimal firstSalary){
    }
}