package com.aabrasha.entity.money;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by Abrasha on 07-Jan-16.
 */
public class MoneyAmountTest {

    @Test
    public void testValueOf() throws Exception{
        MoneyAmount amount = MoneyAmount.valueOf("1.11");
        MoneyAmount amount2 = MoneyAmount.valueOf("2.22");
        System.out.println(amount);
        System.out.println(amount2);

        amount.amountProperty().bindBidirectional(amount2.amountProperty());
        System.out.println(amount);
        System.out.println(amount2);

        amount.setAmount(new BigDecimal("123.1"));
        System.out.println(amount);
        System.out.println(amount2);


    }



    @Test
    public void testMultiply() throws Exception{

        BigDecimal num = new BigDecimal("124512.128231");
        System.out.println(num);

        num = num.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(num);

        num = num.multiply(new BigDecimal(0.15));
        System.out.println(num);

        DecimalFormat decimalFormat = new DecimalFormat("###,###,###.00");
        System.out.println(decimalFormat.format(num.doubleValue()));
        System.out.println(124512.128231 * 0.15);


    }

}