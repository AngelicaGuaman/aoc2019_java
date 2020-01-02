package org.aoc2019.day;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day2 extends Day {

    private static final Integer FINISHED = 99;
    private static final Integer ADD = 1;
    private static final Integer MULTIPLY = 2;

    public Day2(String fileName) {
        super(fileName);
    }

    public void returnTotalFuel() {
        BufferedReader rd = null;

        try {
            // Open the file for reading.
            rd = new BufferedReader(new FileReader(new File(getFileName())));

            // Read all contents of the file.
            String[] inputIntegers = rd.readLine().split(",");
            List<Integer> integersList = Arrays.stream(inputIntegers).map(Integer::new).collect(Collectors.toList());

            for(Integer integer: integersList){
                if ( integer == ADD) {

                }else if(integer == MULTIPLY ){

                }
            }
        } catch (IOException ex) {
            System.err.println("An IOException was caught!");
            ex.printStackTrace();
        }
    }
}
