package unit8;

public class Unit8Exercise {
    public static void main(String[] args) {

    }

    /**
     * Returns the larger of the two roots of the quadratic equation *A*x*x+B*x+C=0,providedithasanyroots. IfA==0or
     * if the discriminant, B*B - 4*A*C, is negative, then an exception * of type IllegalArgumentException is thrown.
     */
    static public double root(double A, double B, double C)
            throws IllegalArgumentException {
        if (A == 0) {
            throw new IllegalArgumentException("A can’t be zero.");
        } else {
            double disc = B * B - 4 * A * C;
            if (disc < 0)
                throw new IllegalArgumentException("Discriminant < zero.");
            return (-B + Math.sqrt(disc)) / (2 * A);
        }
    }
}
