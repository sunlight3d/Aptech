package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PointManagement {
    private ArrayList<Point> points = new ArrayList<>();
    private HashMap<String, Point> hashPoints = new HashMap<>();

    private ArrayList<String> words = new ArrayList<>(List.of("watermelon", "cat", "dog"));
    public static int NUMBER_OF_COLUMNS = 10;
    public static int NUMBER_OF_ROWS = 9;
    public PointManagement() {
        generatePoints();
    }
    public Point getPointFromHashMap(int i, int j) {
        return hashPoints.get(String.format("%d:%d", i, j));
    }
    private void generatePoints() {
        for (int i = 0; i < NUMBER_OF_ROWS; i++) {
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
                Point point = new Point(i, j);
                points.add(point);
                hashPoints.put(String.format("%d:%d", i, j), point);
            }
        }
    }
    public Point randomPoint() {
        //return null => het cho
        if(points.stream()
                .filter((Point point) -> point.getCharacter().length() == 0)
                .toList().size() == 0) {
            return null;
        }
        while (true) {
            Point point = getPointFromHashMap(
                    Helper.random(0, NUMBER_OF_ROWS - 1),
                    Helper.random(0, NUMBER_OF_COLUMNS - 1)
            );
            if(point.getCharacter().length() == 0) {
                return point;
            }
        }
    }
    private void calculateMatrixSize() {
        int totalCharacters = 0;
        for(String word: words) {
            totalCharacters += word.length();
        }
        NUMBER_OF_COLUMNS = (int)Math.pow(Math.round(Math.ceil(totalCharacters)), 2);
        NUMBER_OF_ROWS = (int)Math.pow(Math.round(Math.ceil(totalCharacters)), 2);
    }
    public void fillWords() {
        calculateMatrixSize();
        words.forEach((String word) -> {
            fillWord(word);
        });
    }
    private void fillWord(String word) {
        //backup points for back-tracking
        ArrayList<Point> backupPoints = new ArrayList<>();
        for(int i = 0; i < word.length(); i++) {
            String character = Character.toString(word.charAt(i));
            //random i, j
            Point point = randomPoint();
            backupPoints.add(point);
            Point nextPoint = point.move();
            if(nextPoint == null && i == word.length() - 1) {
                for (Point backupPoint: backupPoints) {
                    backupPoint.setCharacter("");
                }
                break;
            } else {
                point.setCharacter(character);
            }
        }
    }
    public void show() {
        for (int i = 0; i < NUMBER_OF_ROWS; i++) {
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
                Point point = getPointFromHashMap(i, j);
                System.out.print(point);
                if(j == NUMBER_OF_COLUMNS - 1) {
                    System.out.println();
                }
            }
        }
    }
}
