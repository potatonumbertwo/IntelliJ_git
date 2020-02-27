package Unit4;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * For this exercise, you should write a program
 * that can be used as a
 * "set calculator" for simple operations on sets of
 * non-negative integers. (Negative integers are not allowed.)
 * A set of such integers will be represented as a list of integers,
 * separated by commas and, optionally,
 * spaces and enclosed in square brackets.
 * For example: [1,2,3] or [17, 42, 9, 53,108].
 * The characters +, *, and - will be used for the union,
 * intersection, and difference operations.
 * The user of the program will type in lines of input containing two sets,
 * separated by an operator. The program should perform the operation and
 * print the resulting set. Here are some examples:
 * <p>
 * Input Output
 * ------------------------- -------------------
 * [1, 2, 3] + [3, 5, 7] [1, 2, 3, 5, 7]
 * [10,9,8,7] * [2,4,6,8] [8]
 * [ 5, 10, 15, 20 ] - [ 0, 10, 20 ] [5, 15]
 * <p>
 * To represent sets of non-negative integers,
 * use sets of type TreeSet<Integer>. Read the user's input,
 * create two TreeSets, and use the appropriate TreeSet method
 * to perform the requested operation on the two sets.
 * Your program should be able to read and process
 * any number of lines of input. If a line contains a syntax error,
 * your program should not crash.
 * It should report the error and move on to the next line of input.
 * (Note: To print out a Set, A, of Integers,
 * you can just say System.out.println(A).
 * Here, the syntax for sets to be the same as that used by the system for
 * outputting a set.)
 */
public class SetCalculator {
    public static void main(String[] args) {


        TreeSet<Integer> set1 = new TreeSet<Integer>();
        TreeSet<Integer> set2 = new TreeSet<Integer>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        System.out.println(set1);

        set2.add(3);
        set2.add(4);
        set2.add(5);
        System.out.println(set2);


        Scanner input = new Scanner(System.in);
        System.out.println("Input an operator: ");
        String operator = input.next();

        if (operator.equals("+")) {
            set1.addAll(set2);
            System.out.println(set1);
        }
        if (operator.equals("-")) {
            set1.removeAll(set2);
            System.out.println(set1);
        }
        if (operator.equals("*")) {
            set1.retainAll(set2);
            System.out.println(set1);
        }

    }
}
