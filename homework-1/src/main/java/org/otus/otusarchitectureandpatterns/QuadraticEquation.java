package org.otus.otusarchitectureandpatterns;

public class QuadraticEquation {

    public static final double EPS = 1e-5;

    public double[] solve(double a, double b, double c) {
        validateNumbers(a, b, c);

        double discriminant = calculateDiscriminant(a, b, c);
        if (Math.abs(discriminant) < EPS) {
            double root = -b / (2 * a);
            return new double[]{root, root};
        } else if (discriminant > EPS) {
            double firstRoot = (-b + Math.sqrt(discriminant)) / (2 * a);
            double secondRoot = (-b - Math.sqrt(discriminant)) / (2 * a);

            return new double[]{firstRoot, secondRoot};
        } else {
            return new double[]{};
        }
    }

    private void validateNumbers(double a, double b, double c) {
        if (a < EPS) {
            throw new IllegalArgumentException("a = " + a + "can not be less then zero");
        }
        if (Double.isInfinite(a) || Double.isInfinite(b) || Double.isInfinite(c)) {
            throw new IllegalArgumentException("one or more of the arguments are infinite");

        }

        if (Double.isNaN(a) || Double.isNaN(b) || Double.isNaN(c)) {
            throw new IllegalArgumentException("one or more of the arguments are NaN");
        }
    }

    public double calculateDiscriminant(double a, double b, double c) {
        return Math.pow(b, 2) - 4 * a * c;
    }
}