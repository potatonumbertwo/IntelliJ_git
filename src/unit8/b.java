package unit8;

import java.util.Arrays;

public class b {

    public static void main(String args[]) {

        int maxSizeArray = 10000;
//Compute benchmarks
        int[] sortingArray1;
        sortingArray1 = new int[maxSizeArray];
        int[] sortingArray2;
        sortingArray2 = new int[maxSizeArray];
//Create two different arrays

        for (int i = 0; i < sortingArray1.length; i++) {
// Filling two arrays with the same random numbers.
            sortingArray1[i] = (int) (Integer.MAX_VALUE * Math.random());
            sortingArray2[i] = sortingArray1[i];

        }


        long startTime1 = System.currentTimeMillis();
//Compute time for SelectionSort
        selectionSort(sortingArray1);
// Sorting Array1 with SelectionSort
        long runTime1 = System.currentTimeMillis() - startTime1;
//Compute run time
        System.out.println("SelectionSort time is " + runTime1 / 1000.0 + "seconds");
//Print result

        long startTime2 = System.currentTimeMillis();
//Compute time for Arrays.sort
        Arrays.sort(sortingArray2);
// Sorting Array2 with Arrays.sort
        long runTime2 = System.currentTimeMillis() - startTime2;
//Compute run time
        System.out.println("Arrays Sort time is:" + runTime2 / 1000.0 + "seconds");
//Print result

    }


    static void selectionSort(int[] A) {
// Sort A into increasing order, using selection sort
        for (int lastPlace = A.length - 1; lastPlace > 0; lastPlace--) {
// Find the largest item among A[0], A[1], ...,
// A[lastPlace], and move it into position lastPlace
// by swapping it with the number that is currently
// in position lastPlace.
            int maxLoc = 0; // Location of largest item seen so far.
            for (int j = 1; j <= lastPlace; j++) {
                if (A[j] > A[maxLoc]) {
// Since A[j] is bigger than the maximum we’ve seen
// so far, j is the new location of the maximum value
// we’ve seen so far.
                    maxLoc = j;
                }
            }
            int temp = A[maxLoc]; // Swap largest item with A[lastPlace].
            A[maxLoc] = A[lastPlace];
            A[lastPlace] = temp;
        }
    }
}


