package com.aabrasha.helpers;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Abrasha on 05-Jan-16.
 */
public class StringUtilsExtraTest {

    @Test
    public void testRemoveFirstCharacter(){

        String s1 = null;
        String s2 = "";
        String s3 = "ABCZ";
        String s4 = "ABCZ_";
        String s5 = "A";

        assertNull(StringUtilsExtra.removeFirstCharacter(s1));
        assertNull(StringUtilsExtra.removeFirstCharacter(s2));

        assertNotNull(StringUtilsExtra.removeFirstCharacter(s3));
        assertEquals("BCZ", StringUtilsExtra.removeFirstCharacter(s3));

        assertNotNull(StringUtilsExtra.removeFirstCharacter(s4));
        assertEquals("BCZ_", StringUtilsExtra.removeFirstCharacter(s4));
        assertNotNull(StringUtilsExtra.removeFirstCharacter(s5));
        assertEquals("", StringUtilsExtra.removeFirstCharacter(s5));
        assertTrue(StringUtilsExtra.removeFirstCharacter(s5).isEmpty());
    }



    public void testRemoveLastCharacter(){
        String s1 = null;
        String s2 = "";
        String s3 = "ABCZ";
        String s4 = "ABCZ_";
        String s5 = "A";

        assertNull(StringUtilsExtra.removeLastCharacter(s1));
        assertNull(StringUtilsExtra.removeLastCharacter(s2));

        assertNotNull(StringUtilsExtra.removeLastCharacter(s3));
        assertEquals("ABC", StringUtilsExtra.removeLastCharacter(s3));

        assertNotNull(StringUtilsExtra.removeLastCharacter(s4));
        assertEquals("ABCZ", StringUtilsExtra.removeLastCharacter(s4));

        assertNotNull(StringUtilsExtra.removeLastCharacter(s5));
        assertEquals("", StringUtilsExtra.removeLastCharacter(s5));
        assertTrue(StringUtilsExtra.removeLastCharacter(s5).isEmpty());
    }

}
