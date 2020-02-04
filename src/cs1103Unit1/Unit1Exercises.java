package cs1103Unit1;

public class Unit1Exercises {
    public static void main(String[] args) {

System.out.println(root1(5,6,1));
    }

    /**
     * Returns the larger of the two roots of the quadratic equation
     * A*x*x + B*x + C = 0, provided it has any roots.  If A == 0 or
     * if the discriminant, B*B - 4*A*C, is negative, then an exception
     * of type IllegalArgumentException is thrown.
     */
    static public double root(double A, double B, double C)
            throws IllegalArgumentException {
        if (A == 0) {
            throw new IllegalArgumentException("A can't be zero.");
        } else {
            double disc = B * B - 4 * A * C;
            if (disc < 0)
                throw new IllegalArgumentException("Discriminant < zero.");
            return (-B + Math.sqrt(disc)) / (2 * A);
        }
    }

    /**
     * Returns the larger of the two roots of
     * the quadratic equation * A*x*x+B*x+C=0.
     * Precondition: A != 0 and B*B - 4*A*C >= 0.
     */
    static public double root1(double A, double B, double C) {
        assert A != 0 : "Leading coefficient of quadratic " +
                "equation cannot be zero.";
        double disc = B * B - 4 * A * C;
        assert disc >= 0 : "Discriminant of quadratic equation cannot be negative.";
        return (-B + Math.sqrt(disc)) / (2 * A);

    }
}
