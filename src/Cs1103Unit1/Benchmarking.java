package Cs1103Unit1;

import java.util.*;

public class Benchmarking {
    //given by a constant array size
    static final int arrayLength = 500;

    /**
     * selection sort method copied from textbook
     *
     * @param A
     */
    static void selectionSort(int[] A) {
        // Sort A into increasing order, using selection sort
        for (int lastPlace = A.length - 1; lastPlace > 0; lastPlace--) {
            // Find the largest item among A[0], A[1], ...,
            // A[lastPlace], and move it into position lastPlace
            // by swapping it with the number that is currently
            // in position lastPlace.
            int maxLoc = 0;  // Location of largest item seen so far.
            for (int j = 1; j <= lastPlace; j++) {
                if (A[j] > A[maxLoc]) {
                    // Since A[j] is bigger than the maximum we’ve seen
                    // so far, j is the new location of the maximum value
                    // we’ve seen so far.
                    maxLoc = j;
                }
            }
            int temp = A[maxLoc];  // Swap largest item with A[lastPlace].
            A[maxLoc] = A[lastPlace];
            A[lastPlace] = temp;
        }  // end of for loop
    }

    public static void main(String[] args) {

        int[] array1 = new int[arrayLength];
        int[] array2 = new int[arrayLength];

        // fill the array with random integers
        for (int i = 0; i < array1.length; i++) {
            int x = (int) (Integer.MAX_VALUE * Math.random());
            array1[i] = x; //fill the random integer for the first array
        }
        array2 = array1.clone(); // create an identical contents for the second array

        // call the selection sort run time method
        double selectionSortRunTime = selectionSortRunTime(array1);
        System.out.println("When the array size at " +
                arrayLength +
                " the selection sort run time is " +
                selectionSortRunTime + " milliseconds");

        // call the selection sort run time method and show the outcome
        double arraysRunTime = arraysRunTime(array2);
        System.out.print("When the array size at ");
        System.out.print(arrayLength);
        System.out.print(" quick sort run time is ");
        System.out.print(arraysRunTime + " milliseconds");

    }

    /**
     * compute the runtime of selection sort
     *
     * @param array
     * @return
     */
    public static double selectionSortRunTime(int[] array) {
        long startTime = System.currentTimeMillis();
        selectionSort(array);
        long endTime = System.currentTimeMillis();
        double runTime = endTime - startTime;
        return runTime;
    }

    /**
     * compute the runtime of build-in quick sort
     *
     * @param inputArray
     * @return
     */
    public static double arraysRunTime(int[] inputArray) {
        double runTimeOfArrays;
        long arrayStartTime = System.currentTimeMillis();
        Arrays.sort(inputArray);
        long arraysEndTime = System.currentTimeMillis();
        runTimeOfArrays = arraysEndTime - arrayStartTime;
        return runTimeOfArrays;

    }

}
