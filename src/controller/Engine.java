package controller;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import model.Matrix;
import model.Vector;
import view.Window;

import java.util.List;

public class Engine {
    private static Vector complexVector;
    private static Vector vectorC;
    private static Vector vectorPhi;
    private static Matrix plodBolnoyFantazii;
    private static List<Shape> currentPoints;
    private static List<Shape> primaryPoints;
    private static int pointsCount;
    private static int n;

    public static void main(String[] args) {
        Window.run(args);
    }

    public static void stepForward(){
        if(n < pointsCount) {
            n++;
            vectorPhi = plodBolnoyFantazii.multiply(Handler.transform(vectorC, n));
            System.out.println(vectorPhi.toString());
            Window.removeAll(currentPoints);
            currentPoints = Handler.convert(vectorPhi, Color.BLACK);
            Window.showShapes(currentPoints);
        }
    }

    public static void stepBack(){
        if(n > 0) {
            n--;
            vectorPhi = plodBolnoyFantazii.multiply(Handler.transform(vectorC, n));
            System.out.println(vectorPhi.toString());
            Window.removeAll(currentPoints);
            currentPoints = Handler.convert(vectorPhi, Color.BLACK);
            Window.showShapes(currentPoints);
        }
    }

    public static void showPrimaryVector(int count){
        if (currentPoints != null) {
            Window.removeAll(currentPoints);
        }
        complexVector = new Vector(Handler.generateRandomComplex(count));
        System.out.println(complexVector.toString());
        plodBolnoyFantazii = Handler.generatePBF(complexVector.length());
        vectorC = Handler.gauss(plodBolnoyFantazii, complexVector);
        currentPoints = Handler.convert(complexVector, Color.BLACK);
        primaryPoints = Handler.convert(complexVector, Color.DEEPSKYBLUE);
        Window.showShapes(currentPoints);
        Window.showShapes(primaryPoints);
        pointsCount = count;
        n = 0;
    }
}
