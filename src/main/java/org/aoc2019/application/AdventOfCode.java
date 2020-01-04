package org.aoc2019.application;

import org.aoc2019.day.Day1;
import org.aoc2019.day.Day2;
import org.aoc2019.utils.File;

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
        int[] nounAndVerb = new int[2];
        nounAndVerb[0] = 12;
        nounAndVerb[1] = 2;
        day2.calculatePositionZero(nounAndVerb[0], nounAndVerb[1]);
        nounAndVerb = day2.calculateNounAndVerb();
        day2.calculatePositionZero(nounAndVerb[0], nounAndVerb[1]);

    }
}
