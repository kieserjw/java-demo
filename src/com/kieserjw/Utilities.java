package com.kieserjw;

import java.text.DecimalFormat;

public class Utilities {
    
    // prints number as int if possible, otherwise a double with two trailing digits
    public static String printDecimal(double d) {
        // select a "tolerance range" for being an integer
        double TOLERANCE = 1E-5;
        if (Math.abs(Math.floor(d) - d) < TOLERANCE) {
            return ((int) d) + "";
        } else {
            DecimalFormat f = new DecimalFormat("##.00");
            return f.format(d);
        }
    }
}
