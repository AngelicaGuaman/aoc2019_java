package org.aoc2019.day;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class Day3 extends Day {
    private static Point origin = new Point(0,0);
    private static List<Point> line1 = new ArrayList<>();
    private static List<Point> line2 = new ArrayList<>();
    private static List<Point> pointsIntersection = new ArrayList<>();

    public Day3(List<String> lines) {
        super(lines);
    }

    public Optional<Integer> calculateDistanceBetweenWires() {
        line1 = this.getPointList(getInputs().get(0));
        line2 = this.getPointList(getInputs().get(1));

        pointsIntersection = line1.stream().filter(line2::contains).collect(toList());
        Optional<Integer> distance = pointsIntersection.stream().filter(point -> !point.equals(origin)).
                map(point -> Math.abs(point.x) + Math.abs(point.y)).min(Integer::compare);
        return distance;
    }

    public Optional<Integer> calculateNumOfSteps() {
        Optional<Integer> numSteps = pointsIntersection.stream().filter(point -> !point.equals(origin)).
                map(point -> line1.indexOf(point) + line2.indexOf(point)).min(Integer::compare);
        return numSteps;
    }

    private List<Point> getPointList(String line) {
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
