package org.aoc2019.day;

import org.aoc2019.utils.Intcode;

import java.util.Arrays;
import java.util.List;

public class Day2 extends Day {
    private static final int CHECK_VALUE = 19690720;
    private static final int MAX_VALUE = 100;

    public Day2(List<String> lines) {
        super(lines);
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
        numbers[1] = noun;
        numbers[2] = verb;
        Intcode intcode = new Intcode(1);

        return intcode.calculate(numbers);
    }

}
