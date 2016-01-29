package com.aabrasha.entity;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Abrasha on 03-Jan-16.
 */
@Entity
@Table(name = "companies")
public class Company implements Serializable {

    private IntegerProperty id = new SimpleIntegerProperty(0);

    private StringProperty name = new SimpleStringProperty();
    private StringProperty edrpou = new SimpleStringProperty();
    private StringProperty account = new SimpleStringProperty();
    private StringProperty regNumber = new SimpleStringProperty();
    private StringProperty address = new SimpleStringProperty();

    private ObjectProperty<PensionFund> pensionFund = new SimpleObjectProperty<>();
    private ObjectProperty<Employee> boss = new SimpleObjectProperty<>();
    private ObjectProperty<Employee> mainAccountant = new SimpleObjectProperty<>();

    private ObservableList<Employee> employees = FXCollections.observableArrayList();



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId(){
        return id.get();
    }



    public void setId(int id){
        this.id.set(id);
    }



    @Basic
    @Column(name = "name")
    public String getName(){
        return name.get();
    }



    public void setName(String name){
        this.name.set(name);
    }



    @Basic
    @Column(name = "EDRPOU")
    public String getEdrpou(){
        return edrpou.get();
    }



    public void setEdrpou(String edrpou){
        this.edrpou.set(edrpou);
    }



    @Basic
    @Column(name = "account")
    public String getAccount(){
        return account.get();
    }



    public void setAccount(String account){
        this.account.set(account);
    }



    @Basic
    @Column(name = "reg_number")
    public String getRegNumber(){
        return regNumber.get();
    }



    public void setRegNumber(String regNumber){
        this.regNumber.set(regNumber);
    }



    public void setEmployees(ObservableList<Employee> employees){
        this.employees = employees;
    }



    @Basic
    @Column(name = "address")
    public String getAddress(){
        return address.get();
    }



    public void setAddress(String address){
        this.address.set(address);
    }



    @OneToOne(cascade = CascadeType.ALL)
    public PensionFund getPensionFund(){
        return pensionFund.getValue();
    }



    public void setPensionFund(PensionFund pensionFund){
        this.pensionFund.set(pensionFund);
    }



    @OneToOne(cascade = CascadeType.ALL)
    public Employee getBoss(){
        return boss.getValue();
    }



    public void setBoss(Employee boss){
        this.boss.set(boss);
    }



    @OneToOne(cascade = CascadeType.ALL)
    public Employee getMainAccountant(){
        return mainAccountant.getValue();
    }



    public void setMainAccountant(Employee mainAccountant){
        this.mainAccountant.set(mainAccountant);
    }



    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    public List<Employee> getEmployees(){
        return employees;
    }



    public void setEmployees(List<Employee> employees){
        this.employees = FXCollections.observableArrayList(employees);
    }


//    @OneToOne(cascade = CascadeType.ALL)
//    public Address getAddress(){
//        return address.get();
//    }
//
//
//
//    public void setAddress(Address address){
//        this.address.set(address);
//    }



    public boolean addEmployee(Employee added){
        return added != null ? employees.add(added) : false;
    }



    public void removeEmployee(Employee employee){
        // TODO
    }



    public void removeEmployee(int id){
        // TODO
    }



    public IntegerProperty idProperty(){
        return id;
    }



    public StringProperty nameProperty(){
        return name;
    }



    public StringProperty edrpouProperty(){
        return edrpou;
    }



    public StringProperty accountProperty(){
        return account;
    }



    public StringProperty regNumberProperty(){
        return regNumber;
    }



    public ObjectProperty<PensionFund> pensionFundProperty(){
        return pensionFund;
    }



    public StringProperty addressProperty(){
        return address;
    }



    public ObjectProperty<Employee> mainAccountantProperty(){
        return mainAccountant;
    }



    public ObjectProperty<Employee> bossProperty(){
        return boss;
    }



    public ObservableList<Employee> employees(){
        return employees;
    }



    @Override
    public String toString(){
        return "Company{" +
                "id=" + id.get() +
                ", name=" + name.get() +
                ", edrpou=" + edrpou.get() +
                ", account=" + account.get() +
                ", regNumber=" + regNumber.get() +
                ", pensionFund=" + pensionFund.get() +
                ", address=" + address.get() +
                ", boss=" + boss.get() +
                ", mainAccountant=" + mainAccountant.get() +
                ", \nemployees=" + employees +
                '}';
    }
}
