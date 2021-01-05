package question5;

// Optimized Merge Sort
// Merge method of standard merge sort algorithm can 
// be modified to solve this problem. 
// While merging two sorted halves say left and right, we need to merge
// in such a way that negative part of left and right subarray is copied 
// first followed by positive part of left and right sub-array.
public class Method4 {
    static void printArray(int A[], int size) {
        for (int i = 0; i < size; ++i) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }

    // Merges two subarrays of arr[].
    // First subarray is arr[1...m].
    // Second subarray is arr[m+1...r].
    static void merge(int arr[], int l, int m, int r) {
        int i, j, k;
        int n1 = m - l + 1;
        int n2 = r - m;

        /* create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /* Copy data to temp arrays L[] and R[] */
        for (i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        /* Merge the temp arrays back into arr[l..r] */
        // Initial index of first subarray
        i = 0;

        // Initial index of second subarray
        j = 0;

        // Initial index of merged subarray
        k = l;

        // Note the order of appearance of elements should
        // be maintained - we copy elements of left subarray
        // first followed by that of right subarray

        // copy negative elements of left subarray
        while (i < n1 && L[i] < 0) {
            arr[k++] = L[i++];
        }

        // copy negative elements of right subarray
        while (j < n2 && R[j] < 0) {
            arr[k++] = R[j++];
        }

        // copy positive elements of left subarray
        while (i < n1) {
            arr[k++] = L[i++];
        }

        // copy positive elements of right subarray
        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    // Function to Rearrange positive and negative
    // numbers in a array
    static void RearrangePosNeg(int arr[], int l, int r) {
        if (l < r) {
            // Same as (l+r)/2, but avoids overflow for
            // large l and r
            int m = l + (r - l) / 2;

            // Sort first and second halves
            RearrangePosNeg(arr, l, m);
            RearrangePosNeg(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    // Driver program
    public static void main(String[] args) {
        int arr[] = { -12, 11, -13, -5, 6, -7, 5, -3, -6 };
        int arr_size = arr.length;
        RearrangePosNeg(arr, 0, arr_size - 1);
        printArray(arr, arr_size);
    }
}
