package com.kieserjw;

import org.junit.runner.JUnitCore;

public class Main {

    public static void main(String[] args) {
        System.out.println("Code Sample #1: Input and Analysis");
        JUnitCore.runClasses(InputandAnalysisTest.class);
        System.out.println();
        System.out.println("Code Sample #2: Scanning");
        JUnitCore.runClasses(FileScannerTest.class);
    }
}
