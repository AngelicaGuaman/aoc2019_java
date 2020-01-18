package org.aoc2019.day;

import org.aoc2019.utils.Intcode;

import java.util.Arrays;
import java.util.List;

public class Day6 extends Day {

    public Day6(List<String> inputs) {
        super(inputs);
    }

    public int calculate() {
        int[] numbers = Arrays.stream(getInputs().get(0).split(","))
                .mapToInt(Integer::parseInt).toArray();

        Intcode intcode = new Intcode(1);
        return intcode.calculate(numbers);
    }
}
