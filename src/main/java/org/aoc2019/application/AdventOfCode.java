package org.aoc2019.application;

import org.aoc2019.day.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AdventOfCode {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.lines(Paths.get("src/main/resources/day1.txt"))
                .collect(Collectors.toList());
        Day1 day1 = new Day1(lines);
        day1.returnTotalFuel();

        lines = Files.lines(Paths.get("src/main/resources/day2.txt"))
                .collect(Collectors.toList());
        Day2 day2 = new Day2(lines);
        int result = day2.calculatePositionZero(12, 2);
        System.out.println("Result: " + result);
        result = day2.calculateNounAndVerb();
        System.out.println("Result: " + result);

        lines = Files.lines(Paths.get("src/main/resources/day3.txt"))
                .collect(Collectors.toList());
        Day3 day3 = new Day3(lines);

        Optional<Integer> distance = day3.calculateDistanceBetweenWires();
        if (distance.isPresent()) {
            System.out.println("Distance: " + distance.get());
        }

        Optional<Integer> numSteps = day3.calculateNumOfSteps();
        if (distance.isPresent()) {
            System.out.println("Steps: " + numSteps.get());
        }

        Day4 day4 = new Day4();
        int passwords = day4.getPasswordPart1();
        System.out.println("Number of passwords - Part 1: " + passwords);
        passwords = day4.getPasswordPart2();
        System.out.println("Number of passwords - Part 2: " + passwords);

        lines = Files.lines(Paths.get("src/main/resources/day5.txt"))
                .collect(Collectors.toList());
        Day5 day5 = new Day5(lines);
        result = day5.calculate();
        System.out.println("Result Day 5 Part 1: " + result);
    }
}
