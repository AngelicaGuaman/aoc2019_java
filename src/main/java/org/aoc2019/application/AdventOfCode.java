package org.aoc2019.application;

import org.aoc2019.day.Day1;
import org.aoc2019.day.Day2;

public class AdventOfCode {

    public static void main(String[] args) {
        Day1 day1 = new Day1("src/main/resources/day1.txt");
        day1.returnTotalFuel();

        Day2 day2 = new Day2("src/main/resources/day2.txt");
        day2.returnPositionZero();
    }
}
