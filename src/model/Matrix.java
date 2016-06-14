package model;

import java.util.Arrays;

public class Matrix {
    private Complex[][] mas;

    public Matrix(int columns, int length){
        mas = new Complex[columns][length];
    }

    public Matrix(Matrix matrix){
        mas = new Complex[matrix.columnsCount()][matrix.length()];
        for(int i = 0; i < matrix.columnsCount(); i++){
            for(int j = 0; j < matrix.length(); j++){
                mas[i][j] = get(i, j);
            }
        }
    }

    public Matrix hermitian(){
        Matrix res = new Matrix(columnsCount(), length());
        for(int i = 0; i < columnsCount(); i++){
            for(int j = 0; j < length(); j++){
                res.set(i, j, mas[i][j].conjugate());
            }
        }
        return res;
    }

    public void set(int column, int position, Complex complex){
        mas[column][position] = complex;
    }

    public Complex get(int column, int position){
        return mas[column][position];
    }

    public int length(){
        return mas[0].length;
    }

    public int columnsCount(){
        return mas.length;
    }

    public Complex[][] getMas() {
        return mas;
    }

    public void setMas(Complex[][] mas) {
        this.mas = mas;
    }
}
