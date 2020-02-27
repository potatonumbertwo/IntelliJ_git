package Cs1103Unit2;

public class Unit2Exercise {

    /**
     * @param args
     */
    public static void main(String[] args) {


        System.out.println(factorial(5));
        System.out.print("\n");
        System.out.println(fibonacci(7));

    }

    /**
     * @param n
     * @return return n * factorial(n - 1)
     */

    public static Integer factorial(Integer n) {
        if (n == 0) return 1;
        System.out.print(n + " ");
        if (n > 0) return n * factorial(n - 1);
        return n;
    }

    /**
     * @param n
     * @return fibonacci(n - 1) + fibonacci(n - 2)
     */

    public static Integer fibonacci(Integer n) {
        if (n == 0) return 1;
        if (n == 1) return 1;

        if (n > 0) return fibonacci(n - 1) + fibonacci(n - 2);
        return n;
    }


}