package com.aabrasha.entity.money;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Abrasha on 07-Jan-16.
 */
public class MoneyAmountTest {

    @Test
    public void testValueOf() throws Exception{
        MoneyAmount ma1 = MoneyAmount.valueOf("123123,12");
        MoneyAmount ma2 = new MoneyAmount(12312312);
        assertNotNull(ma1);
        assertEquals(12312312, ma1.getAmount());
        assertEquals(ma2, ma1);

        MoneyAmount ma3 = MoneyAmount.valueOf("123141");
        assertEquals(ma3.getAmount(), 12314100);
        assertEquals("123141,00", ma3.toString());

        MoneyAmount ma4 = MoneyAmount.valueOf("123141,5");
        assertEquals(ma4.getAmount(), 12314150);
        assertEquals("123141,50", ma4.toString());

        MoneyAmount ma5 = MoneyAmount.valueOf("123141,,5");
        assertNull(ma5);

        MoneyAmount ma6 = MoneyAmount.valueOf("123141,");
        assertEquals("123141,00", ma6.toString());


    }



    @Test
    public void testGetAmount() throws Exception{

    }

}