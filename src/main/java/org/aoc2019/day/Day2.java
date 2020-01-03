package org.aoc2019.day;

import java.util.Arrays;
import java.util.List;

public class Day2 extends Day {

    private static final Integer FINISHED = 99;
    private static final Integer ADD = 1;
    private static final Integer MULTIPLY = 2;

    public Day2(List<String> inputs) {
        super(inputs);
    }

    public void returnPositionZero() {
        int[] numbers = Arrays.stream(getInputs().get(0).split(",")).mapToInt(Integer::parseInt).toArray();
        int index = 0;
        numbers[1] = 12;
        numbers[2] = 2;

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
    }
}
