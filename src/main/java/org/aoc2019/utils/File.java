package org.aoc2019.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class File {

    private String fileName;

    public File(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public List<String> readFile() {
        BufferedReader rd = null;
        List<String> lines = null;

        try {
            // Open the file for reading.
            rd = new BufferedReader(new FileReader(new java.io.File(getFileName())));
            lines = rd.lines().map(String::new).collect(Collectors.toList());
            rd.close();
        } catch (IOException ex) {
            System.err.println("An IOException was caught!");
            ex.printStackTrace();
        }
        return lines;
    }
}
