package com.kieserjw;

import java.text.DecimalFormat;

public class Utilities {
    
    public static void printDecimal(double d) {
        // select a "tolerance range" for being an integer
        double TOLERANCE = 1E-5;
        if (Math.abs(Math.floor(d) - d) < TOLERANCE) {
            System.out.println((int) d);
        } else {
            DecimalFormat f = new DecimalFormat("##.00");
            System.out.println(f.format(d));
        }
    }
    
    public static void printPercentage(double d) {
        DecimalFormat f = new DecimalFormat("##.00");
        System.out.println(f.format(d * 100) + "%");
    }
}
