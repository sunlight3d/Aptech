package org.example.exercise02;

public class ThreadData {
    private String[] data = {"Em oi", "Ha noi", "pho"};
    private int currentIndex;

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }
}
