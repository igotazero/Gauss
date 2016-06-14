package model;

public class Complex {
    private double re;
    private double im;

    public Complex(){}

    public Complex(double re) {
        this.re = re;
        this.im = 0;
    }

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public Complex plus(Complex complex) {
        double re = this.re + complex.re;
        double im = this.im + complex.im;
        return new Complex(re, im);
    }

    public Complex multiply(Complex complex){
        double re = this.re * complex.re - this.im * complex.im;
        double im = this.re * complex.im + this.im * complex.re;
        return new Complex(re, im);
    }

    public Complex conjugate() {
        return new Complex(re, -im);
    }

    public double getRe() {
        return re;
    }

    public void setRe(double re) {
        this.re = re;
    }

    public double getIm() {
        return im;
    }

    public void setIm(double im) {
        this.im = im;
    }

    @Override
    public String toString() {
        return re + "|" + im;
    }
}
