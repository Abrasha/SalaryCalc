package com.aabrasha.entity;

import javafx.beans.property.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by abrasha on 12/27/15.
 */
@Entity
@Table(name = "employees")
public class Employee implements Serializable {

    private IntegerProperty id = new SimpleIntegerProperty(0);

    private StringProperty fname = new SimpleStringProperty("");
    private StringProperty lname = new SimpleStringProperty("");
    private StringProperty patronymic = new SimpleStringProperty("");

    private StringProperty code = new SimpleStringProperty("");
    private StringProperty passport = new SimpleStringProperty("");
    private StringProperty position = new SimpleStringProperty("");

    private StringProperty address = new SimpleStringProperty();

    private ObjectProperty<LocalDate> hired = new SimpleObjectProperty<>(null);
    private ObjectProperty<LocalDate> fired = new SimpleObjectProperty<>(null);

    private BooleanProperty hasExpBook = new SimpleBooleanProperty(false);

    private StringProperty phone = new SimpleStringProperty("");

    private ObjectProperty<Company> company = new SimpleObjectProperty<>();
//    private ObjectProperty<Address> address = new SimpleObjectProperty<>();



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId(){
        return id.get();
    }



    public void setId(int id){
        this.id.set(id);
    }



    @Basic
    @Column(name = "fname")
    public String getFname(){
        return fname.get();
    }



    public void setFname(String fname){
        this.fname.set(fname);
    }



    @Basic
    @Column(name = "lname")
    public String getLname(){
        return lname.get();
    }



    public void setLname(String lname){
        this.lname.set(lname);
    }



    @Basic
    @Column(name = "patronymic")
    public String getPatronymic(){
        return patronymic.get();
    }



    public void setPatronymic(String patronymic){
        this.patronymic.set(patronymic);
    }



    @Basic
    @Column(name = "code")
    public String getCode(){
        return code.get();
    }



    public void setCode(String code){
        this.code.set(code);
    }



    @Basic
    @Column(name = "passport")
    public String getPassport(){
        return passport.get();
    }



    public void setPassport(String passport){
        this.passport.set(passport);
    }



    @Column(name = "hired")
    public LocalDate getHired(){
        return hired.get();
    }



    public void setHired(LocalDate hired){
        this.hired.set(hired);
    }



    @Column(name = "fired", nullable = true)
    public LocalDate getFired(){
        return fired.get();
    }



    public void setFired(LocalDate fired){
        this.fired.set(fired);
    }



    @ManyToOne(cascade = CascadeType.ALL)
    public Company getCompany(){
        return company.getValue();
    }



    public void setCompany(Company company){
        this.company.set(company);
    }



    @Column(name = "phone")
    public String getPhone(){
        return phone.get();
    }



    public void setPhone(String phone){
        this.phone.set(phone);
    }



    @Column(name = "has_exp_book")
    public boolean getHasExpBook(){
        return hasExpBook.get();
    }



    public void setHasExpBook(boolean hasExpBook){
        this.hasExpBook.set(hasExpBook);
    }



    @Column(name = "position")
    public String getPosition(){
        return position.get();
    }



    public void setPosition(String position){
        this.position.set(position);
    }



    @Column(name = "address")
    public String getAddress(){
        return address.get();
    }



    public void setAddress(String address){
        this.address.set(address);
    }



    public String getInitials(boolean shortForm){
        StringBuilder builder = new StringBuilder();
        if (!(fname.get().isEmpty())){
            builder.append(shortForm ? fname.get().charAt(0) : fname.get()).append(shortForm ? ". " : ' ');
        }
        if (!(patronymic.get().isEmpty())){
            builder.append(shortForm ? patronymic.get().charAt(0) : patronymic.get()).append(shortForm ? ". " : ' ');
        }
        if (!fname.get().isEmpty()){
            builder.append(fname.get());
        }
        String result = builder.toString();
        return result.isEmpty() ? "Unnamed" : result;
    }



    public IntegerProperty idProperty(){
        return id;
    }



    public StringProperty fnameProperty(){
        return fname;
    }



    public StringProperty lnameProperty(){
        return lname;
    }



    public StringProperty patronymicProperty(){
        return patronymic;
    }



    public StringProperty codeProperty(){
        return code;
    }



    public StringProperty passportProperty(){
        return passport;
    }



    public StringProperty positionProperty(){
        return position;
    }



    public ObjectProperty<LocalDate> hiredProperty(){
        return hired;
    }



    public ObjectProperty<LocalDate> firedProperty(){
        return fired;
    }



    public BooleanProperty hasExpBookProperty(){
        return hasExpBook;
    }



    public StringProperty phoneProperty(){
        return phone;
    }



    public ObjectProperty<Company> companyProperty(){
        return company;
    }



    public StringProperty addressProperty(){
        return address;
    }



    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(lname.get())
                .append(' ')
                .append(fname.get())
                .append(' ')
                .append(patronymic.get());
        return builder.toString();
    }
}
