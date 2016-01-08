package com.aabrasha.entity.money;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by Abrasha on 07-Jan-16.
 */
public class MoneyAmount {

    private ObjectProperty<BigDecimal> amount = new SimpleObjectProperty<>();



    public MoneyAmount(){
        amount.set(new BigDecimal(0));
    }



    public MoneyAmount(BigDecimal amount){
        this.amount.set(amount);
    }



    public static MoneyAmount valueOf(String s){
        s = s.replace(',', '.');
        return new MoneyAmount(new BigDecimal(s));

    }



    public BigDecimal getAmount(){
        return amount.get();
    }



    public void setAmount(BigDecimal amount){
        this.amount.set(amount);
    }



    public ObjectProperty<BigDecimal> amountProperty(){
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
        DecimalFormat format = new DecimalFormat("###,###.00");
        return format.format(amount.get().doubleValue());
    }
}
