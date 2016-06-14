package controller;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import model.Complex;
import model.Matrix;
import model.Point;
import model.Vector;
import view.Window;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Engine {
    private static Vector complexVector;
    private Vector vectorC;
    private Vector vectorPhi;
    private Matrix plodBolnoyFantazii;
    private static List<Shape> currentPoints;

    public static void main(String[] args) {
        Window.run(args);
    }

    public void generatePBF(){
        int size = complexVector.length();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                double re = Math.cos(2 * Math.PI * i * j / size);
                double im = Math.sin(2 * Math.PI * i * j / size);
                plodBolnoyFantazii.set(i, j, new Complex((int)re, (int)im));
            }
        }
    }

    public static void showPrimaryVector(int count){
        if (currentPoints != null) {
            Window.removeAll(currentPoints);
        }
        complexVector = new Vector(Handler.generateRandomComplex(count));
        currentPoints = Handler.convert(complexVector, Color.BLACK);
        Window.showShapes(currentPoints);
    }

    private void removePoints(List<Shape> points){
        Window.removeAll(points);
    }

    private void showPoints(List<Shape> points){
        Window.showShapes(points);
    }
}
