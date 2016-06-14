package controller;

import javafx.scene.paint.Color;
import model.Complex;
import model.Matrix;
import model.Point;
import model.Vector;

/**
 * Created by ������� on 09.06.2016.
 */
public class Test {
    public static void main(String[] args) {
        Vector vector = new Vector(4);
        for(int i = 0; i < vector.length(); i++){
            vector.set(new Complex(1, 1), i);
        }
        Matrix matrix = new Matrix(4, 4);
        for(int i = 0; i < matrix.columnsCount(); i++){
            for(int j = 0; j < matrix.length(); j++){
                matrix.set(i, j, new Complex(2, 1));
            }
        }

        System.out.println("Primary vector");
        System.out.println(vector.toString());
        System.out.println("Primary matrix");
        System.out.println(matrix.toString());
        System.out.println();
        System.out.println("Res vector");
        System.out.println(matrix.multiply(vector).toString());
    }

    public static String method(String s){
        return s + "5";
    }
}

