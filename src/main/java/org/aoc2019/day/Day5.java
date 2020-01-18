package org.aoc2019.day;

import java.util.Arrays;
import java.util.List;

public class Day5 extends Day {

    public Day5(List<String> inputs) {
        super(inputs);
    }

    public void calculate() {
        Arrays.stream(getInputs().get(0).split(","));
    }
}
