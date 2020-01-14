package org.aoc2019.day;

import org.aoc2019.utils.Coordinate;
import org.aoc2019.utils.Direction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day3 {

    public Day3() {
    }

    public HashMap<Direction, List<Coordinate>> groupCoordinatesByDirection(String line) {
        String[] words = line.split(",");
        HashMap<Direction, List<Coordinate>> tableau = new HashMap<>();
        int r = 1, l = -1, u = 1, d = -1;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char direction = word.charAt(0);
            int positions = Integer.parseInt(word.substring(1));

            if (direction == 'R') {
                fillCoordinates(tableau, Direction.RIGHT, r, positions);
                r++;
            } else if (direction == 'L') {
                fillCoordinates(tableau, Direction.LEFT, l, positions);
                l--;
            } else if (direction == 'U') {
                fillCoordinates(tableau, Direction.UP, positions, u);
                u++;
            } else {
                fillCoordinates(tableau, Direction.DOWN, positions, d);
                d--;
            }
        }
        return tableau;
    }

    private void fillCoordinates(HashMap<Direction, List<Coordinate>> tableau, Direction direction, int x, int y) {
        List<Coordinate> coordinates = new ArrayList<>();
        if (tableau.containsKey(direction)) {
            coordinates = tableau.get(direction);
        }
        for (int position = 1; position <= y; position++) {
            Coordinate coordinate = new Coordinate(x, position);
            coordinates.add(coordinate);
        }
        tableau.put(direction, coordinates);
    }
}
