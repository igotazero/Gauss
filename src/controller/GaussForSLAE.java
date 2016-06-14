package controller;

import model.Complex;
import model.Matrix;
import model.Vector;

public final class GaussForSLAE {

	public static Vector<Complex> method(Matrix<Complex> A, Vector<Complex> b) {
		Vector<Complex> x = new Vector<>(Complex.class, b.length());
		b = new Vector(b);
		A = new Matrix(A);
		for (int k = 1; k < A.rowSize(); k++) {
			for (int i = k; i < A.rowSize(); i++) {
				;
				Complex constant = A.get(i, k - 1).div(A.get(k - 1, k - 1));
				for (int j = 0; j < A.colSize(); j++) {
					A.set(i, j, A.get(i, j).sub(constant.mult(A.get(k - 1, j))));
				}
				b.set(i, b.get(i).sub(constant.mult(b.get(k - 1))));
			}
		}
		for (int i = b.size() - 1; i >= 0; i--) {
			x.set(i, b.get(i));
			for (int j = i + 1; j < b.size(); j++) {
				x.set(i, x.get(i).sub(A.get(i, j).mult(x.get(j))));
			}
			x.set(i, x.get(i).div(A.get(i, i)));
		}
		x.reverse();
		return x;
	}
}