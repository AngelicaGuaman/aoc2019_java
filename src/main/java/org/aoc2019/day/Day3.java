package org.aoc2019.day;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Day3 {

    public List<Point> getPointList(String line) {
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
