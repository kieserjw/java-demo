package com.kieserjw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Scan all files and directories below a specified path on a local filesystem.
 */
class FileScanner {
    
    // walk through the given directory and keep track of relevant stats
    // ignores .gitkeep files.  they were necessary to maintain folder structure in git
    static ScanResult scan(String path) {
        ScanResult sr = new ScanResult();
        try {
            Files.walk(Paths.get(path)).forEach(filePath -> {
                if (Files.isRegularFile(filePath) && !filePath.getFileName().toString().equals(".gitkeep")) {
                    sr.numFiles++;
                    try {
                        sr.totalBytes += Files.size(filePath);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (Files.isDirectory(filePath)) {
                    sr.numDirectories++;
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sr;

    }

    static class ScanResult {
        int numFiles = 0;
        int numDirectories = 0;
        long totalBytes = 0;

        // return the number of files scanned
        int getNumFiles() {
            return this.numFiles;
        }

        // return the number of directories scanned
        int getNumDirectories() {
            return this.numDirectories;
        }

        // return the total number of bytes contained within all scanned files
        long getTotalBytes() {
            return this.totalBytes;
        }

        // return the average size of the scanned files
        long getAvgBytes() {
            long avgBytes = 0;
            if (this.numFiles != 0) {
                avgBytes = this.totalBytes / this.numFiles;
            }
            return avgBytes;
        }

        public String toString() {
            String returnString = "";
            returnString += "number of files: " + numFiles + System.lineSeparator();
            returnString += "number of directories: " + numDirectories + System.lineSeparator();
            returnString += "total number of bytes within all files: " + totalBytes + System.lineSeparator();
            returnString += "average size of files: " + getAvgBytes();
            return returnString;
        }
    }

}
