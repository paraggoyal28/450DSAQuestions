package question3;

// Java code for kth smallest element 
// in an array
import java.util.Arrays;

public class MethodOne {
    // Function to return the kth smallest element
    // in the given array
    public static int kthSmallest(Integer[] arr, int k) {
        // Sort the given array
        Arrays.sort(arr);

        // Return the kth element in the sorted array
        return arr[k - 1];
    }

    // driver program
    public static void main(String args[]) {
        Integer arr[] = new Integer[] { 12, 3, 5, 7, 19 };
        int k = 2;
        System.out.println("K'th smallest element is " + kthSmallest(arr, k));
    }
}
