package com.kieserjw;

/**
 * Scan all files and directories below a specified path on a local filesystem.
 */
class FileScanner {
    static ScanResult scan(String path) {
        return null;

    }

    static class ScanResult {
        // return the number of files scanned
        int getNumFiles() {
            return 0;
        }

        // return the number of directories scanned
        int getNumDirectories() {
            return 0;
        }

        // return the total number of bytes contained within all scanned _files_
        long getTotalBytes() {
            return 0;
        }

        // return the average size of the scanned _files_
        long getAvgBytes() {
            return 0;
        }
    }
}
