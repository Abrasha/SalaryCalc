package com.aabrasha.helpers;

import com.aabrasha.entity.Address;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Abrasha on 05-Jan-16.
 */
public class AddressParserTest {

    @Test
    public void testParse(){
        String s1 = "Kiev, Kn. Zaton, 12, kv 32, 87845";
        Address address1 = Address.valueOf(s1);
        assertEquals(address1.getCity(), "Kiev");
        assertEquals("Kn. Zaton, 12, kv 32", address1.getLocalAddress());
        assertEquals("87845", address1.getPostcode());


        Address address2 = new Address("Kiev", "Kn. Zaton, 12, kv 32", "87845");
        assertEquals(address1.getLocalAddress(), address2.getLocalAddress());
        assertEquals(address1.getCity(), address2.getCity());
        assertEquals(address1.getPostcode(), address2.getPostcode());


    }

}
