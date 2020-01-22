package com.JavaForBeginners;

public class Main {

    public static void main(String[] args) {

        // Count the number within the range, init to 0
        int count = 0;
        int sum = 0;

        for (int i = 1; i <= 100; i++) {
            sum += i;
            ++i;
        }
        System.out.println(sum);
    }
}
