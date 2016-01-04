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
@Table(name = "addresses")
public class Address implements Serializable {

    private IntegerProperty id = new SimpleIntegerProperty(0);

    private StringProperty city = new SimpleStringProperty();
    private StringProperty street = new SimpleStringProperty();
    private StringProperty building = new SimpleStringProperty();
    private IntegerProperty flat = new SimpleIntegerProperty();
    private StringProperty postcode = new SimpleStringProperty();



    public Address(){
    }



    public Address(String city, String street, String building, int flat, String postcode){
        this.city.set(city);
        this.street.set(street);
        this.building.set(building);
        this.flat.set(flat);
        this.postcode.set(postcode);
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
    @Column(name = "city")
    public String getCity(){
        return city.get();
    }



    public void setCity(String city){
        this.city.set(city);
    }



    @Basic
    @Column(name = "street")
    public String getStreet(){
        return street.get();
    }



    public void setStreet(String street){
        this.street.set(street);
    }



    @Basic
    @Column(name = "building")
    public String getBuilding(){
        return building.get();
    }



    public void setBuilding(String building){
        this.building.set(building);
    }



    @Basic
    @Column(name = "flat")
    public int getFlat(){
        return flat.get();
    }



    public void setFlat(int flat){
        this.flat.set(flat);
    }



    @Basic
    @Column(name = "postcode")
    public String getPostcode(){
        return postcode.get();
    }



    public void setPostcode(String postcode){
        this.postcode.set(postcode);
    }



    public StringProperty cityProperty(){
        return city;
    }



    public StringProperty streetProperty(){
        return street;
    }



    public StringProperty buildingProperty(){
        return building;
    }



    public IntegerProperty flatProperty(){
        return flat;
    }



    public StringProperty postcodeProperty(){
        return postcode;
    }



    public IntegerProperty idProperty(){
        return id;
    }



    @Override
    public String toString(){

        StringBuilder builder = new StringBuilder();
        builder.append(city.get())
                .append(", ")
                .append(street.get())
                .append(", ")
                .append(building.get())
                .append(", ")
                .append(flat.get())
                .append(", ")
                .append(postcode.get());

        return builder.toString();
    }
}
