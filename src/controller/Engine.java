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
    private static Vector vectorC;
    private static Vector vectorPhi;
    private static Matrix plodBolnoyFantazii;
    private static List<Shape> currentPoints;

    public static void main(String[] args) {
        Window.run(args);
    }

    public static void stepForward(){
        if (plodBolnoyFantazii == null){
            plodBolnoyFantazii = Handler.generatePBF(complexVector.length());
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
}
