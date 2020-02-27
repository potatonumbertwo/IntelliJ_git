package Cs1103Unit1;

import java.util.Scanner;

public class Unit1Exercises {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String answer;
        while (true) {
            try {
                System.out.println("Please enter 3 numbers");
                double A = input.nextDouble();
                double B = input.nextDouble();
                double C = input.nextDouble();

                System.out.println(root(A, B, C));
            } catch (Exception e) {
                System.out.println("There is an error!"+e.getMessage());

            }

            System.out.println("If you want to keep going? Yes/No");
            answer = input.next();

            if (answer.equalsIgnoreCase("Yes")) {

                continue;
            } else break;
        }

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
