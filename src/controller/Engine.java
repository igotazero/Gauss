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
    private static Engine instance;
    private Vector<Complex> currentComplexVector;
    private Vector<Complex> currentVectorC;
    private Vector<Complex> currentVectorPhi;
    private Matrix<Complex> plodBolnoyFantazii;
    private List<Shape> currentPoints;

    private Engine(){}

    public void multiplyMatVec(){
        generatePBF();
        currentVectorC = plodBolnoyFantazii.getHermitian().multiply(currentComplexVector);
        currentVectorPhi = plodBolnoyFantazii.multiply(currentVectorC);
        removePoints(currentPoints);
        System.out.println(currentVectorPhi.toString());;
        showVector(currentVectorPhi);
    }

    public void generatePBF(){
        int size = currentComplexVector.length();
        plodBolnoyFantazii = new Matrix<>(Complex.class, size , size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                double re = Math.cos(2 * Math.PI * i * j / size);
                double im = Math.sin(2 * Math.PI * i * j / size);
                plodBolnoyFantazii.set(i, j, new Complex((int)re, (int)im));
            }
        }
    }

    public void complexVectorGenShow(int count){
        generateComplexVector(count);
        showVector(currentComplexVector);
    }

    private void showVector(Vector<Complex> vector){
        currentPoints = new ArrayList<>();
        for (int i = 0; i < vector.length(); i++){
            Complex c = vector.get(i);
            Point p = new Point((int)c.getRe(), (int)c.getIm(), Color.BLACK);
            currentPoints.add(p);
        }
        Window.showShapes(currentPoints);
    }

    private void generateComplexVector(int count){
        List<Complex> list = generateRandomComplex(count);
        currentComplexVector = new Vector<Complex>(Complex.class, count);
        for(int i = 0; i < count; i++){
            Complex c = list.get(i);
            currentComplexVector.set(i, c);
        }
    }

    private List<Complex> generateRandomComplex(int count){
        List<Complex> complexList = new ArrayList<>();
        int limit = Window.sizeX / 2;
        Random rand = new Random();
        for (int i = 0; i < count; i++){
            Complex complex = new Complex(rand.nextInt(Window.sizeX) - limit, rand.nextInt(Window.sizeX) - limit);
            complexList.add(complex);
        }
        return complexList;
    }

    private void removePoints(List<Shape> points){
        Window.removeAll(points);
    }

    private void showPoints(List<Shape> points){
        Window.showShapes(points);
    }

    public static Engine getInstance(){
        if (instance == null){
            instance = new Engine();
            return instance;
        }else {
            return instance;
        }
    }
}
