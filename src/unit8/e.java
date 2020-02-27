package unit8;


import java.util.Random;

public class e {
    public static void main(String[] args) {
        Random rand = new Random(47);
        boolean flip = rand.nextBoolean();
        System.out.print("OUTCOME: ");
        System.out.println(flip ? "TAIL":"HEAD" );
    }
}