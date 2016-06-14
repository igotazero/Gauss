package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import view.Window;

public class Point extends Circle {
    private int x;
    private int y;
    private final int radius = 2;
    private int displacement = Window.sizeX / 2;

    public Point(int x, int y){
        this.x = x + displacement;
        setCenterX(this.x);
        this.y = y + displacement;
        setCenterY(this.y);
        setRadius(2);
    }

    public Point(int x, int y, Color color){
        this(x, y);
        this.setFill(color);
    }

    public int getX() {
        return x - displacement;
    }

    public void setX(int x) {
        this.x = x + displacement;
    }

    public int getY() {
        return y - displacement;
    }

    public void setY(int y) {
        this.y = y + displacement;
    }
}
