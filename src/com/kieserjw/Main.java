package com.kieserjw;

import org.junit.runner.JUnitCore;

public class Main {

    public static void main(String[] args) {
        JUnitCore.runClasses(InputandAnalysisTest.class);
        
        String path = System.getProperty("user.dir");
        FileScanner.scan(path);
    }

}
