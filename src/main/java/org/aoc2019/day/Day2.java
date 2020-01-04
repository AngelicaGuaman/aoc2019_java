package org.aoc2019.day;

import java.util.Arrays;
import java.util.List;

public class Day2 extends Day {

    private static final int FINISHED = 99;
    private static final int ADD = 1;
    private static final int MULTIPLY = 2;
    private static final int CHECK_VALUE = 19690720;
    private static final int MAX_VALUE = 100;

    public Day2(List<String> inputs) {
        super(inputs);
    }

    public int calculateNounAndVerb() {
        int[] nounAndVerb = new int[2];
        boolean found = false;

        for (int i = 0; !found && i < MAX_VALUE; i++) {
            for (int j = 0; !found && j < MAX_VALUE; j++) {
                int result = this.calculatePositionZero(i, j);
                if (result == CHECK_VALUE) {
                    nounAndVerb[0] = i;
                    nounAndVerb[1] = j;
                    found = true;
                }
            }
        }
        return 100 * nounAndVerb[0] + nounAndVerb[1];
    }

    public int calculatePositionZero(int noun, int verb) {
        int[] numbers = Arrays.stream(getInputs().get(0).split(",")).mapToInt(Integer::parseInt).toArray();
        int index = 0;
        numbers[1] = noun;
        numbers[2] = verb;

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
        return numbers[0];
    }
}
