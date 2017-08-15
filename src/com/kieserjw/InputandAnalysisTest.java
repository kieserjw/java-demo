package com.kieserjw;

import static org.junit.Assert.*;

import java.util.Collections;

import org.junit.Test;

public class InputandAnalysisTest {

    @Test
    public void empty_file() {
        String inputFilename = "input_and_analysis_test_files/empty_file.txt";
        InputandAnalysis iaa = new InputandAnalysis(inputFilename);
        assertEquals(iaa.getNumberList().size(), 0);
        assertEquals(iaa.getStringList().size(), 0);

    }

    @Test
    public void just_numbers() {
        String inputFilename = "input_and_analysis_test_files/just_numbers.txt";
        InputandAnalysis iaa = new InputandAnalysis(inputFilename);
        assertEquals(iaa.getNumberList().size(), 6);
        assertEquals(iaa.getMean(), 5.03333, 1E-5);
        assertEquals(iaa.getMedian(), 5.50, 1E-5);
        assertEquals(iaa.getTotal(), 30.2, 1E-5);
        assertEquals(iaa.getPercentageNumbers(), 1, 1E-5);
    }

    @Test
    public void just_strings() {
        String inputFilename = "input_and_analysis_test_files/just_strings.txt";
        InputandAnalysis iaa = new InputandAnalysis(inputFilename);
        assertEquals(iaa.getStringList().size(), 10);
        String temp = iaa.getStringList().get(0);
        assertEquals(temp, "zeta");
        assertEquals(Collections.frequency(iaa.getStringList(), temp), 2);
    }

    @Test
    public void numbers_and_strings() {
        String inputFilename = "input_and_analysis_test_files/numbers_and_strings.txt";
        InputandAnalysis iaa = new InputandAnalysis(inputFilename);
        assertEquals(iaa.getNumberList().size(), 4);
        assertEquals(iaa.getMean(), 5.55, 1E-5);
        assertEquals(iaa.getMedian(), 5.50, 1E-5);
        assertEquals(iaa.getTotal(), 22.2, 1E-5);
        assertEquals(iaa.getPercentageNumbers(), .33333, 1E-5);

        assertEquals(iaa.getStringList().size(), 8);
        String temp = iaa.getStringList().get(0);
        assertEquals(temp, "The quick brown fox");
        assertEquals(Collections.frequency(iaa.getStringList(), temp), 1);

        // print out information to console
        System.out.println(iaa);
    }

}
