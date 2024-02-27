/**
 * This class finds the median of an array of integers by using a modifed quicksort
 * <p>
 * This class finds the median of an array of specific integers input by the user. The
 * algorithm uses a modified version of the quick sort algorithm to order the integers in
 * accending order than find its median. In cases of even number of integers the median
 * is found by taking the average of the two middle most integers.
 * <p>
 * author Charles Ray and Alfredo Sandoval-Luis
 * edu.uwp.cs.340.course CSCI 340 - Data Structures/Algotrithm Design
 * edu.uwp.cs.340.section 001
 * edu.uwp.cs.340.assignment 2
 * bugs none
 */
public class FindMedian {

    public static double findMedian(int[] array) {
        int n = array.length;
        if (n % 2 == 0) {
            // in the case of an even sized array,
            // find average of 2 middle elements
            return (quickSelect(array, n / 2 - 1) + quickSelect(array, n / 2)) / 2.0;
        } else {
            // otherwise return middle element
            return quickSelect(array, n / 2);
        }
    }

    private static int quickSelect(int[] array, int k) {

        int low = 0, high = array.length - 1;
        // continue for while the pointers do not meet
        while (low < high) {
            // partitioning the array and getting the index of the pivot
            int pivot = partition(array, low, high);
            if (pivot == k) {
                // if the pivot is the kth element then return it
                return array[k];
            } else if (pivot < k) {
                // if the pivot is less than k, we will narrow the
                // search to the right side of the array
                low = pivot + 1;
            } else {
                // else, left side
                high = pivot - 1;
            }
        }
        // when they meet we have found the kth smallest element
        return array[k];
    }

    private static int partition(int[] array, int low, int high) {
        // we are choosing the furthest right element to pivot at
        int pivot = array[high];
        // pointer for the greater element
        int i = low;
        for (int j = low; j < high; j++) {
            // swapping elements if the current one is smaller than
            // or equal to the pivot, swapped with element at i
            if (array[j] <= pivot) {
                swap(array, i, j);
                i++; // moving the pointer on to the greater element
            }
        }
        swap(array, i, high);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        // simple test cases
        //int[] array = {7, 1, 3};
        int[] array = {7, 1, 3, 4};
        System.out.println("Median: " + findMedian(array));
    }
}
