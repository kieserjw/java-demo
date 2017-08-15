package com.kieserjw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class InputandAnalysis {

    private String inputFilename;
    private ArrayList<String> stringList;
    private ArrayList<Double> numberList;
    private double sumNumbers;
    private double mean;
    private double median;

    // create a dummy instance
    public InputandAnalysis() {
        this(null);
    }

    // create an instance with an input file name
    // go through and input file and analyse for strings and numbers
    public InputandAnalysis(String inputFilename) {
        this.inputFilename = inputFilename;
        this.stringList = new ArrayList<String>();
        this.numberList = new ArrayList<Double>();
        this.sumNumbers = 0;
        this.mean = 0;
        this.median = 0;

        this.inputFile();
        this.analyseNumbers();
        this.analyseStrings();
    }

    // read the file name specified into the array lists
    public void inputFile() {

        BufferedReader br = null;
        FileReader fr = null;

        try {
            fr = new FileReader(inputFilename);
            br = new BufferedReader(fr);
            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                try {
                    double d = Double.parseDouble(sCurrentLine);
                    this.numberList.add(d);

                } catch (NumberFormatException ex) {
                    this.stringList.add(sCurrentLine);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();

            // error handling
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    // calculate median, sum, and mean
    public void analyseNumbers() {
        if (this.numberList.size() > 0) {
            Collections.sort(this.numberList);
            int middle = numberList.size() / 2;
            if (numberList.size() % 2 == 1) {
                this.median = numberList.get(middle);
            } else {
                this.median = (numberList.get(middle) + numberList.get(middle - 1)) / 2.0;
            }
            for (int i = 0; i < numberList.size(); i++) {
                this.sumNumbers = numberList.get(i) + this.sumNumbers;
            }
            this.mean = this.sumNumbers / this.numberList.size();
        }
    }

    // sort strings in reverse order
    public void analyseStrings() {
        Collections.sort(this.stringList, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
    }

    // print out the required information
    public String toString() {
        String resultString = "";
        if (this.numberList.size() > 0) {
            resultString += "Sum: " + Utilities.printDecimal(this.getTotal()) + System.lineSeparator();
            resultString += "Mean: " + Utilities.printDecimal(this.getMean()) + System.lineSeparator();
            resultString += "Median: " + Utilities.printDecimal(this.getMedian()) + System.lineSeparator();
            resultString += "Percentage of values that are numbers: "
                    + Utilities.printDecimal(this.getPercentageNumbers() * 100) + "%" + System.lineSeparator();
        }
        if (this.stringList.size() > 0) {
            resultString += "reverse alphabetical distinct list of strings found in the file with number of times that string appeared: ";
            for (int i = 0; i < this.stringList.size(); i++) {
                String temp = this.stringList.get(i);
                if (i == 0 || !temp.equals(this.stringList.get(i - 1))) {
                    resultString += System.lineSeparator() + temp + ": " + Collections.frequency(this.stringList, temp);
                }

            }
        }
        return resultString;
    }

    public double getMean() {
        return this.mean;
    }

    public double getMedian() {
        return this.median;
    }

    public double getTotal() {
        return this.sumNumbers;
    }

    public int getCountOfNumbers() {
        return this.numberList.size();
    }

    public boolean contains(String src) {
        return this.stringList.contains(src);
    }

    public double getPercentageNumbers() {
        return this.numberList.size() / (double) (this.stringList.size() + this.numberList.size());
    }

    public ArrayList<String> getStringList() {
        return this.stringList;
    }

    public ArrayList<Double> getNumberList() {
        return this.numberList;
    }

}
