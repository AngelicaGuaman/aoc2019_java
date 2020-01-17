package org.aoc2019.day;

import org.aoc2019.utils.File;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class Day3 {

    public static void main(String[] args) {
        File file = new File("src/main/resources/day3.txt");
        List<String> lines = file.readFile();
        Day3 day3 = new Day3();
        List<Point> tableauLine1 = day3.groupCoordinatesByDirection(lines.get(0));
        List<Point> tableauLine2 = day3.groupCoordinatesByDirection(lines.get(1));

        List<Point> pointsIntersection = tableauLine1.stream().filter(tableauLine2::contains).collect(toList());
        Optional<Integer> distance = pointsIntersection.stream().filter(point -> !point.equals(new Point(0, 0))).map(point -> Math.abs(point.x) + Math.abs(point.y)).min(Integer::compare);

        if(distance.isPresent()) {
            System.out.println("Distance: " + distance.get());
        }
    }

    private List<Point> groupCoordinatesByDirection(String line) {
        String[] words = line.split(",");
        List<Point> points = new ArrayList<>();
        Point point = new Point(0, 0);
        Point currentPoint = point.getLocation();
        points.add(currentPoint.getLocation());
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char direction = word.charAt(0);
            int positions = Integer.parseInt(word.substring(1));
            if (direction == 'R') {
                for (int j = 0; j < positions; j++) {
                    currentPoint.move(currentPoint.x + 1, currentPoint.y);
                    points.add(currentPoint.getLocation());
                }
            }
            if (direction == 'L') {
                for (int j = 0; j < positions; j++) {
                    currentPoint.move(currentPoint.x - 1, currentPoint.y);
                    points.add(currentPoint.getLocation());
                }
            }
            if (direction == 'U') {
                for (int j = 0; j < positions; j++) {
                    currentPoint.move(currentPoint.x, currentPoint.y + 1);
                    points.add(currentPoint.getLocation());
                }
            }
            if (direction == 'D') {
                for (int j = 0; j < positions; j++) {
                    currentPoint.move(currentPoint.x, currentPoint.y - 1);
                    points.add(currentPoint.getLocation());
                }
            }
        }
        return points;
    }
}
