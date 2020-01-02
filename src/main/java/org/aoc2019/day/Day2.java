package org.aoc2019.day;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

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
            int[] numbers = Arrays.stream(rd.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
            int index = 0;

            while ((index < numbers.length - 3) && (numbers[index] != FINISHED)) {
                if (numbers[index] == ADD) {
                    int pos1 = numbers[index + 1];
                    int pos2 = numbers[index + 2];
                    int dest = numbers[index + 3];
                    numbers[dest] = numbers[pos1] + numbers[pos2];
                } else if (numbers[index] == MULTIPLY) {
                    int pos1 = numbers[index + 1];
                    int pos2 = numbers[index + 2];
                    int dest = numbers[index + 3];
                    numbers[dest] = numbers[pos1] * numbers[pos2];
                } else {
                    System.err.println("Error!");
                }
                index += 4;
            }

            System.out.println("Result: " + Arrays.toString(numbers).replace(", ", ","));
        } catch (IOException ex) {
            System.err.println("An IOException was caught!");
            ex.printStackTrace();
        }
    }
}
