package com.kieserjw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InputandAnalysis {

    private String inputFilename;
    private ArrayList<String> list;

    // create a dummy instance
    public InputandAnalysis() {
        this(null);
    }
    
    // create an instance with an input file name
    public InputandAnalysis(String inputFilename) {
        this.inputFilename = inputFilename;
    }
    
    // read the file name specified into the string array list
    public void inputFile() {

        BufferedReader br = null;
        FileReader fr = null;
        this.list = new ArrayList<String>();
        
        try {
            fr = new FileReader(inputFilename);
            br = new BufferedReader(fr);
            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                list.add(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();

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
    
    // print out the relevant information
    public void analyseFile() {
        System.out.println(this.getTotal());
        System.out.println(this.getCountOfNumbers());
    }
    
    public double getTotal() {
        return 0;
    }
    
    public int getCountOfNumbers() {
        return 0;
    }
    
    public boolean contains(String src) {
        return false;
    }
}
