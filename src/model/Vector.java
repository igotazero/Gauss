package model;

import java.util.Arrays;

public class Vector {
    private Complex[] mas;

    public Vector(int size){
        mas = new Complex[size];
    }

    public Vector(Vector vector){
        mas = Arrays.copyOf(vector.getMas(), vector.length());
    }

    public Vector(Complex[] mas){
        this.mas = mas;
    }

    public void set(Complex complex, int position){
        mas[position] = complex;
    }

    public Complex get(int position){
        return mas[position];
    }

    public Complex[] getMas() {
        return mas;
    }

    public void setMas(Complex[] mas) {
        this.mas = mas;
    }

    public int length(){
        return mas.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Complex c : mas){
            sb.append(c.toString());
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
