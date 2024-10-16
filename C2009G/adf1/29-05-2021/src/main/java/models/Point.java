package models;

public class Point {
    private Double x, y;
    //ten phuong thuc khoi tao(constructor)
    public Point(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }
    public Double getDistance(Point p) {
        return Math.sqrt(Math.pow(this.x - p.getX(), 2) + Math.pow(this.y - p.getY(), 2));
    }
    @Override
    public String toString() {
        return String.format("x = %f, y = %f", x, y);
    }
}
