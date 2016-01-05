package com.aabrasha.helpers;

/**
 * Created by Abrasha on 05-Jan-16.
 */
public class StringUtilsExtra {

    public static final String EMPTY_STRING = "";

    public static String removeFirstCharacter(String s){
        if (s == null || s.length() < 1)
            return null;
        if (s.length() == 1)
            return EMPTY_STRING;

        return s.substring(1, s.length());
    }

    public static String removeLastCharacter(String s){
        if (s == null || s.isEmpty())
            return null;

        if (s.length() == 1)
            return EMPTY_STRING;

        return s.substring(0, s.length() - 1);
    }

}
