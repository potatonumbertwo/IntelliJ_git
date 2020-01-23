package com.JavaForBeginners;

public class Main {

    public static void main(String[] args) {

        // Count the number within the range, init to 0
        int count = 0;
        int sum = 0;

        for (count = 1; count <= 100; count++) {
            sum += count;

        }
        System.out.println(sum);
    }
}
