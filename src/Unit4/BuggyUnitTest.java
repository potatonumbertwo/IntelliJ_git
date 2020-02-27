package Unit4;

import org.junit.Assert;
import org.junit.Test;

public class BuggyUnitTest {


    @Test
    public void bubbleSortTest() {
        int[] array = {2, 4, 6, 7, 8, 9, 3, 8, 9, 2};
        int[] sortArray = {2, 2, 3, 4, 6, 7, 8, 8, 9, 9};
        BuggySearchAndSort.bubbleSort(array);
        Assert.assertArrayEquals(sortArray, array);


    }

    @Test
    public void selectionSortTest() {
        int[] array = {2, 4, 6, 7, 8, 9, 3, 8, 9, 2};
        int[] sortArray = {2, 2, 3, 4, 6, 7, 8, 8, 9, 9};
        BuggySearchAndSort.selectionSort(array);
        Assert.assertArrayEquals(sortArray, array);


    }

    @Test
    public void insertionSortTest() {
        int[] array = {2, 4, 6, 7, 8, 9, 3, 8, 9, 2};
        int[] sortArray = {2, 2, 3, 4, 6, 7, 8, 8, 9, 9};
        BuggySearchAndSort.insertionSort(array);
        Assert.assertArrayEquals(sortArray, array);


    }

    @Test
    public void insertionSortTest2() {
        int[] array = {9, 9, 9, 10, 3, 6, 7, 1, 3, 9};
        int[] sortArray = {1, 3, 3, 6, 7, 9, 9, 9, 9, 10};
        BuggySearchAndSort.insertionSort(array);
        Assert.assertArrayEquals(sortArray, array);

    }

    @Test
    public void containTest() {
        int[] array = {2, 5, 3, 1, 2, 7, 7, 5, 8, 1};
        boolean con = BuggySearchAndSort.contains(array, 5);

        Assert.assertEquals(true, con);

    }

    @Test
    public void containTest2() {
        int[] array = {2, 5, 3, 1, 2, 7, 7, 5, 8, 1};
        boolean con = BuggySearchAndSort.contains(array, 11);

        Assert.assertEquals(false, con);

    }
}

