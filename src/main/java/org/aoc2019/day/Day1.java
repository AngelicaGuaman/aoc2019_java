package org.aoc2019.day;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Day1 extends Day {

    public Day1(String fileName) {
        super(fileName);
    }

    public void returnTotalFuel() {
        BufferedReader rd = null;

        try {
            // Open the file for reading.
            rd = new BufferedReader(new FileReader(new File(getFileName())));

            // Read all contents of the file.
            String inputLine = null;
            Long totalFuelPart1 = 0L, totalFuelPart2 = 0L;

            while ((inputLine = rd.readLine()) != null) {
                Long mass = Long.parseLong(inputLine);
                totalFuelPart1 += calculateFuel(mass);
                totalFuelPart2 += calculateNotNegativeFuel(mass);
            }

            System.out.println("total Fuel part1 : " + totalFuelPart1);
            System.out.println("total Fuel part2 : " + totalFuelPart2);

        } catch (IOException ex) {
            System.err.println("An IOException was caught!");
            ex.printStackTrace();
        }
    }

    private Long calculateFuel(Long mass) {
        return (mass / 3) - 2;
    }

    private Long calculateNotNegativeFuel(Long mass) {
        Long totalFuel = calculateFuel(mass);
        return totalFuel < 0 ? 0 : totalFuel + calculateNotNegativeFuel(totalFuel);
    }
}
