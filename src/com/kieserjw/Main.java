package com.kieserjw;

public class Main {

    public static void main(String[] args) {
        String inputFilename = "input.txt";
        InputandAnalysis iaa = new InputandAnalysis(inputFilename);
        iaa.inputFile();
        iaa.analyseFile();
    }

}
