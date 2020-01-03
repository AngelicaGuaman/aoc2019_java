package org.aoc2019.day;

import java.util.List;

public class Day1 extends Day {

    public Day1(List<String> inputs) {
        super(inputs);
    }

    public void returnTotalFuel() {
        Long totalFuelPart1 = 0L, totalFuelPart2 = 0L;

        for (String input : getInputs()) {
            Long mass = Long.parseLong(input);
            totalFuelPart1 += calculateFuel(mass);
            totalFuelPart2 += calculateNotNegativeFuel(mass);
        }

        System.out.println("total Fuel part1 : " + totalFuelPart1);
        System.out.println("total Fuel part2 : " + totalFuelPart2);
    }

    private Long calculateFuel(Long mass) {
        return (mass / 3) - 2;
    }

    private Long calculateNotNegativeFuel(Long mass) {
        Long totalFuel = calculateFuel(mass);
        return totalFuel < 0 ? 0 : totalFuel + calculateNotNegativeFuel(totalFuel);
    }
}
