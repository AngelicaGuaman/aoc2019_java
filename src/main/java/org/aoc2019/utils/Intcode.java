package org.aoc2019.utils;

public class Intcode {

    private static final int FINISHED = 99;
    private static final int ADD = 1;
    private static final int MULTIPLY = 2;
    private static final int WRITE = 3;

    public Intcode() {
    }

    public int calculate(int[] numbers) {
        int index = 0;
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
            } else if (numbers[index] == WRITE) {

            } else {
                System.err.println("Error!");
            }
            index += 4;
        }
        return numbers[0];
    }
}
