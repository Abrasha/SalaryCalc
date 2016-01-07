package com.aabrasha.entity.money;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Created by Abrasha on 07-Jan-16.
 */
public class MoneyAmount {

    private IntegerProperty amount = new SimpleIntegerProperty();



    public MoneyAmount(){
    }



    public MoneyAmount(int amount){
        this.amount.set(amount);
    }



    public static MoneyAmount valueOf(String s){
        String[] parts = s.split(",");

        if (parts.length > 2){
            System.out.println("Wrong argument: " + s);
            return null;
        }

        if (parts.length == 1){
            return new MoneyAmount(Integer.valueOf(parts[0]) * 100);
        }

        if (parts[1].length() > 2){
            System.out.println("Wrong argument: " + s);
            return null;
        }

        int value;
        int kopecks = 0;

        if (parts[1].length() == 1)
            kopecks = Integer.valueOf(parts[1]) * 10;

        if (parts[1].length() == 2)
            kopecks = Integer.valueOf(parts[1]);

        value = Integer.valueOf(parts[0]) * 100 + kopecks;
        return new MoneyAmount(value);
    }



    public int getAmount(){
        return amount.get();
    }



    public void setAmount(int amount){
        this.amount.set(amount);
    }



    public IntegerProperty amountProperty(){
        return amount;
    }



    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoneyAmount amount1 = (MoneyAmount) o;
        return amount == amount1.amount;
    }



    @Override
    public String toString(){

        return String.format("%d,%02d", amount.get() / 100, amount.get() % 100);
    }
}
