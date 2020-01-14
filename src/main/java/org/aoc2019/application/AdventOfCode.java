package org.aoc2019.application;

import org.aoc2019.day.Day1;
import org.aoc2019.day.Day2;
import org.aoc2019.day.Day3;
import org.aoc2019.utils.Coordinate;
import org.aoc2019.utils.Direction;
import org.aoc2019.utils.File;

import java.util.HashMap;
import java.util.List;

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
        Day3 day3 = new Day3();
        HashMap<Direction, List<Coordinate>> tableauLine1 = day3.groupCoordinatesByDirection(lines.get(0));
        HashMap<Direction, List<Coordinate>> tableauLine2 = day3.groupCoordinatesByDirection(lines.get(1));
        HashMap<Direction, List<Coordinate>> c = day3.groupCoordinatesByDirection(lines.get(0));
    }
}
