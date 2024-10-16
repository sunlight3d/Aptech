package org.example.exercise01;

public class ThreadData {
    private int randomX;
    private int randomY;
    public int generateRandomNumber(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }

    public int getRandomX() {
        return randomX;
    }

    public void setRandomX(int randomX) {
        this.randomX = randomX;
    }

    public int getRandomY() {
        return randomY;
    }

    public void setRandomY(int randomY) {
        this.randomY = randomY;
    }
}
