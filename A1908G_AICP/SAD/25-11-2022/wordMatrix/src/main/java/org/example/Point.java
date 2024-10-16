package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Point {
    private int i, j;
    private String character = "";
    private ArrayList<Direction> directions = new ArrayList<Direction>(List.of(
            Direction.UP,
            Direction.UP_RIGHT,
            Direction.RIGHT,
            Direction.RIGHT_BOTTOM,
            Direction.BOTTOM,
            Direction.BOTTOM_LEFT,
            Direction.LEFT,
            Direction.LEFT_UP
    ));
    private ArrayList<Direction> passedDirections = new ArrayList<Direction>();

    public Point(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public Point move(){
        return new Point(1,1);
    }
    @Override
    public String toString() {
        return String.format("i:%d,j:%d,%s  ", i, j,character);
    }
}
