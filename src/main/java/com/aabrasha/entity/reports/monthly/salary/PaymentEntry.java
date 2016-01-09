package com.aabrasha.entity.reports.monthly.salary;

import com.aabrasha.entity.EmployeesSalary;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * Created by Abrasha on 07-Jan-16.
 */
public class PaymentEntry {

    // TODO define all values as DoubleProperty

    //    public static final double ESV_TAX_RATE = 0.036;
    public static final double INCOME_TAX_RATE = 0.18;
    public static final double MILITARY_TAX_RATE = 0.015;

    private ObjectProperty<EmployeesSalary> employeesSalary = new SimpleObjectProperty<>();
    private DoubleProperty pieceSalary = new SimpleDoubleProperty();
    private DoubleProperty otherSalary = new SimpleDoubleProperty();
    private DoubleProperty togetherSalary = new SimpleDoubleProperty();
    private DoubleProperty firstPartSalary = new SimpleDoubleProperty();
    private DoubleProperty incomeTax = new SimpleDoubleProperty();
    private DoubleProperty militaryTax = new SimpleDoubleProperty();
    private DoubleProperty togetherTax = new SimpleDoubleProperty();
    private DoubleProperty totalToPay = new SimpleDoubleProperty();



    public PaymentEntry(EmployeesSalary employeesSalary, double pieceSalary, double firstSalary){
        this(employeesSalary, pieceSalary, firstSalary, 0);
    }



    public PaymentEntry(EmployeesSalary employeesSalary, double pieceSalary, double firstSalary, double otherSalary){
        this.employeesSalary.set(employeesSalary);
        this.pieceSalary.set(pieceSalary);
        this.firstPartSalary.set(firstSalary);
        this.otherSalary.set(otherSalary);
        doBinding();
    }



    private void doBinding(){
        togetherSalary.bind(pieceSalary.add(otherSalary).add(employeesSalary.get().rateSalaryProperty()));
        incomeTax.bind(togetherSalary.multiply(INCOME_TAX_RATE));
        militaryTax.bind(togetherSalary.multiply(MILITARY_TAX_RATE));
        togetherTax.bind(incomeTax.add(militaryTax).add(firstPartSalary));
        totalToPay.bind(togetherSalary.subtract(togetherTax));
    }



    public double getTotalToPay(){
        return totalToPay.get();
    }



    public void setTotalToPay(double totalToPay){
        this.totalToPay.set(totalToPay);
    }



    public DoubleProperty totalToPayProperty(){
        return totalToPay;
    }



    public double getTogetherTax(){
        return togetherTax.get();
    }



    public void setTogetherTax(double togetherTax){
        this.togetherTax.set(togetherTax);
    }



    public DoubleProperty togetherTaxProperty(){
        return togetherTax;
    }



    public double getMilitaryTax(){
        return militaryTax.get();
    }



    public void setMilitaryTax(double militaryTax){
        this.militaryTax.set(militaryTax);
    }



    public DoubleProperty militaryTaxProperty(){
        return militaryTax;
    }



    public double getIncomeTax(){
        return incomeTax.get();
    }



    public void setIncomeTax(double incomeTax){
        this.incomeTax.set(incomeTax);
    }



    public DoubleProperty incomeTaxProperty(){
        return incomeTax;
    }



    public double getFirstPartSalary(){
        return firstPartSalary.get();
    }



    public void setFirstPartSalary(double firstPartSalary){
        this.firstPartSalary.set(firstPartSalary);
    }



    public DoubleProperty firstPartSalaryProperty(){
        return firstPartSalary;
    }



    public double getTogetherSalary(){
        return togetherSalary.get();
    }



    public void setTogetherSalary(double togetherSalary){
        this.togetherSalary.set(togetherSalary);
    }



    public DoubleProperty togetherSalaryProperty(){
        return togetherSalary;
    }



    public double getOtherSalary(){
        return otherSalary.get();
    }



    public void setOtherSalary(double otherSalary){
        this.otherSalary.set(otherSalary);
    }



    public DoubleProperty otherSalaryProperty(){
        return otherSalary;
    }



    public double getPieceSalary(){
        return pieceSalary.get();
    }



    public void setPieceSalary(double pieceSalary){
        this.pieceSalary.set(pieceSalary);
    }



    public DoubleProperty pieceSalaryProperty(){
        return pieceSalary;
    }



    public EmployeesSalary getEmployeesSalary(){
        return employeesSalary.get();
    }



    public void setEmployeesSalary(EmployeesSalary employeesSalary){
        this.employeesSalary.set(employeesSalary);
    }



    public ObjectProperty<EmployeesSalary> employeesSalaryProperty(){
        return employeesSalary;
    }
}