package org.aoc2019.application;

import org.aoc2019.day.*;
import org.aoc2019.utils.File;

import java.util.List;
import java.util.Optional;

public class AdventOfCode {

    public static void main(String[] args) {
        File file = new File("src/main/resources/day1.txt");
        List<String> lines = file.readFile();
        Day1 day1 = new Day1(lines);
        day1.returnTotalFuel();

        file = new File("src/main/resources/day2.txt");
        lines = file.readFile();
        Day2 day2 = new Day2(lines);
        int result = day2.calculatePositionZero(12, 2);
        System.out.println("Result: " + result);
        result = day2.calculateNounAndVerb();
        System.out.println("Result: " + result);

        file = new File("src/main/resources/day3.txt");
        lines = file.readFile();
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

        file = new File("src/main/resources/day5.txt");
        lines = file.readFile();
        Day5 day5 = new Day5(lines);
        result = day5.calculate();
        System.out.println("Result Day 5 Part 1: " + result);
    }
}
