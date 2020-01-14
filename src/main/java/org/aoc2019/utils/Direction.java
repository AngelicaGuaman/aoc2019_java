package org.aoc2019.utils;

public enum Direction {
    RIGHT('R'), LEFT('L'), UP('U'), DOWN('D');

    private char value;

    Direction(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}
