package model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Matrix<T> {
    private List<T[]> matrix;

    public Matrix(Class<T> c, int length, int rows){
        matrix = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            @SuppressWarnings("unchecked")
            final T[] a = (T[]) Array.newInstance(c, length);
            matrix.add(a);
        }
    }

    public Matrix<Complex> getHermitian() {
        Matrix<Complex> res = new Matrix<>(Complex.class, this.length(), this.length());
        for (int i = 0; i < length(); i++) {
            for (int j = 0; j < length(); j++) {
                Complex c = (Complex)this.get(i, j);
                res.set(i, j, c.conjugate());
            }
        }
        return res;
    }

    public Vector<Complex> multiply(Vector<Complex> vector){
        Vector<Complex> res = new Vector<>(Complex.class, vector.length());
        for (int i = 0; i < length(); i++) {
            Complex sum = new Complex(0);
            for (int j = 0; j < length(); j++) {
                Complex com = (Complex)this.get(i, j);
                sum = sum.add(com.multiply(vector.get(j)));
            }
            res.set(i, sum);
        }
        return res;
    }

    public T get(int i, int j){
        T[] element = matrix.get(i);
        return element[j];
    }

    public void set(int i, int j, T type){
        T[] element = matrix.get(i);
        element[j] = type;
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < matrix.size(); i++){
            T[] current = matrix.get(i);
            for (int j = 0; j < current.length; j++){
                res = res + current[j].toString() + " ";
            }
            res = res + "\n";
        }
        return res.trim();
    }

    public int length(){
        return matrix.size();
    }
}
