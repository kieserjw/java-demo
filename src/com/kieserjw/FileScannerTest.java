package com.kieserjw;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import com.kieserjw.FileScanner.ScanResult;

public class FileScannerTest {

    // scan through empty directory with no files or directories
    @Test
    public void empty_directory() {
        String path = System.getProperty("user.dir") + File.separator + "file_scanner_test_files" + File.separator
                + "foo" + File.separator + "buzzwords" + File.separator + "paradigm_shift";
        ScanResult sr = FileScanner.scan(path);
        assertEquals(sr.getNumFiles(), 0);
        assertEquals(sr.getNumDirectories(), 1);
        assertEquals(sr.getTotalBytes(), 0);
        assertEquals(sr.getAvgBytes(), 0);
    }

    // scan through directory with only other sub-directories
    @Test
    public void only_directories() {
        String path = System.getProperty("user.dir") + File.separator + "file_scanner_test_files" + File.separator
                + "foo";
        ScanResult sr = FileScanner.scan(path);
        assertEquals(sr.getNumFiles(), 0);
        assertEquals(sr.getNumDirectories(), 5);
        assertEquals(sr.getTotalBytes(), 0);
        assertEquals(sr.getAvgBytes(), 0);
    }

    // scan through flat directory with only files
    @Test
    public void only_files() {
        String path = System.getProperty("user.dir") + File.separator + "file_scanner_test_files" + File.separator
                + "bar";
        ScanResult sr = FileScanner.scan(path);
        assertEquals(sr.getNumFiles(), 1);
        assertEquals(sr.getNumDirectories(), 1);
        assertEquals(sr.getTotalBytes(), 576);
        assertEquals(sr.getAvgBytes(), 576);
    }

    // scan through multi-leveled directory with many files and sub-directories
    @Test
    public void files_and_directories() {
        String path = System.getProperty("user.dir") + File.separator + "file_scanner_test_files";
        ScanResult sr = FileScanner.scan(path);
        assertEquals(sr.getNumFiles(), 4);
        assertEquals(sr.getNumDirectories(), 7);
        assertEquals(sr.getTotalBytes(), 23995);
        assertEquals(sr.getAvgBytes(), 5998);
        
        // print out information to console
        System.out.println(sr);
    }

}
