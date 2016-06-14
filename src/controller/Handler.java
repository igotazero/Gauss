package controller;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import model.Complex;
import model.Point;
import model.Vector;
import view.Window;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Handler {
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
            res.set(i, point);
        }
        return res;
    }
}
