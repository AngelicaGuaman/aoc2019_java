package org.aoc2019.day;

import org.aoc2019.utils.Coordinate;
import org.aoc2019.utils.Direction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day3 {
    HashMap<Direction, List<Coordinate>> tableau;
    private Direction direction;

    public Day3() {
        tableau = new HashMap<>();
    }

    public HashMap<Direction, List<Coordinate>> groupCoordinatesByDirection(String line) {
        String[] words = line.split(",");
        HashMap<Direction, List<Coordinate>> tableau = new HashMap<>();
        int r = 1, l = -1, u = 1, d = -1;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char direction = word.charAt(0);
            int positions = Integer.parseInt(word.substring(1));
            List<Coordinate> coordinates = new ArrayList<>();

            if (direction == 'R') {
                if (tableau.containsKey(Direction.RIGHT)) {
                    coordinates = tableau.get(Direction.RIGHT);
                }
                for (int position = 1; position <= positions; position++) {
                    Coordinate coordinate = new Coordinate(r, position);
                    coordinates.add(coordinate);
                }
                tableau.put(Direction.RIGHT, coordinates);
                r++;
            } else if (direction == 'L') {
                coordinates = new ArrayList<>();
                if (tableau.containsKey(Direction.LEFT)) {
                    coordinates = tableau.get(Direction.LEFT);
                }
                for (int position = 1; position <= positions; position++) {
                    Coordinate coordinate = new Coordinate(l, position);
                    coordinates.add(coordinate);
                }
                tableau.put(Direction.LEFT, coordinates);
                l--;
            } else if (direction == 'U') {
                coordinates = new ArrayList<>();
                if (tableau.containsKey(Direction.UP)) {
                    coordinates = tableau.get(Direction.UP);
                }
                for (int position = 1; position <= positions; position++) {
                    Coordinate coordinate = new Coordinate(position, u);
                    coordinates.add(coordinate);
                }
                tableau.put(Direction.UP, coordinates);
                u++;
            } else {
                coordinates = new ArrayList<>();
                if (tableau.containsKey(Direction.DOWN)) {
                    coordinates = tableau.get(Direction.DOWN);
                }
                for (int position = 1; position <= positions; position++) {
                    Coordinate coordinate = new Coordinate(position, d);
                    coordinates.add(coordinate);
                }
                tableau.put(Direction.DOWN, coordinates);
                d--;
            }
        }
        return tableau;
    }

    private void fillCoordinates(HashMap<Direction, List<Coordinate>> tableau, int x, int y) {
        List<Coordinate> coordinates = new ArrayList<>();
        if (tableau.containsKey(Direction.RIGHT)) {
            coordinates = tableau.get(Direction.RIGHT);
        }
        for (int position = 1; position <= y; position++) {
            Coordinate coordinate = new Coordinate(x, position);
            coordinates.add(coordinate);
        }
        tableau.put(Direction.RIGHT, coordinates);
    }
}
