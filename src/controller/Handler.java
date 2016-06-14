package controller;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import model.Complex;
import model.Matrix;
import model.Point;
import model.Vector;
import view.Window;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Handler {
    public static Vector transform(Vector vector, int n){
        Vector res = new Vector(vector.length());
        double[] mas = new double[vector.length()];
        for(int i = 0; i < mas.length; i++){
            mas[i] = vector.get(i).abs();
        }
        Arrays.sort(mas);
        double radius = (n > 0) ? mas[n - 1] : 0;
        for(int i = 0; i < mas.length; i++){
            if (vector.get(i).abs() > radius){
                res.set(vector.get(i), i);
            }else {
                res.set(new Complex(0), i);
            }
        }
        return res;
    }

    public static Vector gauss(Matrix matrix, Vector vector){
        Vector res = new Vector(vector.length());
        for(int n = 1; n < matrix.columnsCount(); n++){
            for(int i = n; i < matrix.columnsCount(); i++){
                Complex constant = matrix.get(i, n - 1).division((matrix.get(n - 1, n -1)));
                for(int j = 0; j < matrix.length(); j++){
                    matrix.set(i, j, matrix.get(i, j).subtraction(
                            constant.multiply(matrix.get(n - 1, j))));
                }
                vector.set(vector.get(i).subtraction(constant.multiply(vector.get(n - 1))), i);
            }
        }
        for(int i = vector.length() - 1; i >= 0; i--){
            res.set(vector.get(i), i);
            for(int j = i + 1; j < vector.length(); j++){
                res.set(res.get(i).subtraction(matrix.get(i, j).multiply(res.get(j))), i);
            }
            res.set(res.get(i).division(matrix.get(i, i)), i);
        }
        return res.invert();
    }

    public static Complex[] generateRandomComplex(int count){
        Complex[] mas = new Complex[count];
        int limit = Window.sizeX / 2;
        Random rand = new Random();
        for (int i = 0; i < count; i++){
            mas[i] = new Complex(rand.nextInt(Window.sizeX) - limit, rand.nextInt(Window.sizeX) - limit);
        }
        return mas;
    }

    public static List<Shape> convert(Vector vector, Color color){
        List<Shape> res = new ArrayList<>();
        for(int i = 0; i < vector.length(); i++){
            Point point = new Point((int)vector.get(i).getRe(), (int)vector.get(i).getIm(), color);
            res.add(point);
        }
        return res;
    }

    public static Matrix generatePBF(int size){
        Matrix matrix = new Matrix(size, size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                double re = Math.cos(2 * Math.PI * i * j / size);
                double im = Math.sin(2 * Math.PI * i * j / size);
                matrix.set(i, j, new Complex(re, im));
            }
        }
        return matrix;
    }
}
