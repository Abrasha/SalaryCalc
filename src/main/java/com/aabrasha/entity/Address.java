package com.aabrasha.entity;

import com.aabrasha.helpers.StringUtilsExtra;
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
    private StringProperty localAddress = new SimpleStringProperty();
    private StringProperty postcode = new SimpleStringProperty();



    public Address(){
    }



    public Address(String city, String localAddress, String postcode){
        this.city.set(city);
        this.localAddress.set(localAddress);
        this.postcode.set(postcode);
    }



    //"Kiev, mira, 14, kB 12, 8484"
    public static Address valueOf(String value){
        String[] parts = value.split(",");
        String localAddress = StringUtilsExtra.removeFirstCharacter(parts[1]);
        for (int i = 2; i < parts.length - 1; i++){
            localAddress += ',' + parts[i];
        }
        String city = parts[0];
        String postCode = StringUtilsExtra.removeFirstCharacter(parts[parts.length - 1]);

        return new Address(city, localAddress, postCode);
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
    @Column(name = "local_ddress")
    public String getLocalAddress(){
        return localAddress.get();
    }



    public void setLocalAddress(String street){
        this.localAddress.set(street);
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



    public StringProperty localAddressProperty(){
        return localAddress;
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
                .append(localAddress.get())
                .append(", ")
                .append(postcode.get());

        return builder.toString();
    }
}
