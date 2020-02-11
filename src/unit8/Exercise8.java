package unit8;

public class Exercise8 {
    public static void main(String[] args) {


//        System.out.println(factorial(5));
        System.out.println(even(18));
    }


    public static int even(int k) {
        if (k == 0) {
            return 1;
//            System.out.println("k = 0");
        }
        System.out.println("k = " + k);
        return even(k - 1) + 2;

    }

    public static Integer factorial(Integer n) {
        if (n == 1) return 1;
        System.out.println("n = " + n);
        return n * factorial(n - 1);
    }

    public static int powerOfTwo(int number) {
        if (number == 0) return 1;
        return number;
    }

//        System.out.println(powerOfTwo(8));
}
