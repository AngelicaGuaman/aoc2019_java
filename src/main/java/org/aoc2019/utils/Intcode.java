package org.aoc2019.utils;

public class Intcode {

    private static final int FINISHED = 99;
    private static final int ADD = 1;
    private static final int MULTIPLY = 2;
    private static final int IN = 3;
    private static final int OUT = 4;

    public Intcode() {
    }

    public int calculate(int[] numbers) {
        int index = 0;
        while ((index < numbers.length - 3) && (numbers[index] != FINISHED)) {
            int number = numbers[index];
            int operation = number % 100;
            int[] modes = calculateModes(number);
            if (operation == ADD) {
                addOrMultiply(numbers, modes, index, '+');
                index += 4;
            } else if (operation == MULTIPLY) {
                addOrMultiply(numbers, modes, index, '*');
                index += 4;
            } else if (operation == IN) {
                int storedValue = 50;
                int dest = numbers[index + 1];
                numbers[dest] = storedValue;
                index += 2;
            } else if (operation == OUT) {
                int output = numbers[index + 1];
                System.out.println("OUTPUT: " + output);
                index += 2;
            } else {
                System.err.println("Error!");
            }
        }
        return numbers[0];
    }

    private int[] calculateModes(int number) {
        int[] modes = new int[3];
        int result = number / 100;
        for (int i = 0; i < 3; i++) {
            modes[i] = result % 10;
            result /= 100;
        }
        return modes;
    }

    private void addOrMultiply(int[] numbers, int[] modes, int index, char operation) {
        int pos1 = numbers[index + 1];
        int pos2 = numbers[index + 2];
        int dest = numbers[index + 3];

        int number1 = getParameter(numbers, modes[0], pos1);
        int number2 = getParameter(numbers, modes[1], pos2);
        numbers[dest] = operation == '*' ? number1 * number2 : number1 + number2;

    }

    private int getParameter(int[] numbers, int mode, int indexOrNumber) {
        if (mode == 0) {
            return numbers[indexOrNumber];
        }

        return indexOrNumber;
    }
}
