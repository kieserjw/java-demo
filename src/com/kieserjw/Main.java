package com.kieserjw;

public class Main {

    public static void main(String[] args) {
        String inputFilename = "test.txt";
        InputandAnalysis iaa = new InputandAnalysis(inputFilename);
        iaa.inputFile();
        iaa.analyseFile();
    }

}
