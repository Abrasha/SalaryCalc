package com.aabrasha.entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Abrasha on 03-Jan-16.
 */
@Entity
@Table(name = "pension_funds")
public class PensionFund implements Serializable {

    private IntegerProperty id = new SimpleIntegerProperty(0);

    private StringProperty name = new SimpleStringProperty();
    private StringProperty code = new SimpleStringProperty();



    public PensionFund(){
    }



    public PensionFund(String name, String code){
        this.name.set(name);
        this.code.set(code);
    }



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId(){
        return id.get();
    }



    public void setId(int id){
        this.id.set(id);
    }



    @Basic
    @Column(name = "pf_name")
    public String getName(){
        return name.get();
    }



    public void setName(String name){
        this.name.set(name);
    }



    @Basic
    @Column(name = "pf_code")
    public String getCode(){
        return code.get();
    }



    public void setCode(String code){
        this.code.set(code);
    }



    public IntegerProperty idProperty(){
        return id;
    }



    public StringProperty codeProperty(){
        return code;
    }



    public StringProperty nameProperty(){
        return name;
    }


}
