package question5;

public class Method5 {
    /* Function to print the array */
    static void printArray(int A[], int size) {
        for (int i = 0; i < size; ++i) {
            System.out.print(A[i] + " ");
        }
        System.out.println("");
    }

    /*
     * Function to reverse an array. // An array can be reversed in O(n) time // and
     * O(1) space.
     */

    static int[] swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    static void reverse(int arr[], int l, int r) {
        if (l < r) {
            arr = swap(arr, l, r);
            reverse(arr, ++l, r--);
        }
    }

    static void merge(int arr[], int l, int m, int r) {
        int i = l; // Initial index of 1st subarray
        int j = m + 1; // Initial index of 2nd

        while (i <= m && arr[i] < 0) {
            i++;
        }

        // arr[i..m] is positive

        while (j <= r && arr[j] < 0) {
            j++;
        }

        // arr[j..r] is positive

        // reverse positive part of the
        // left sub-array(arr[i..m])
        reverse(arr, i, m);

        // reverse negative part of the
        // right sub-array(arr[m+1...j-1])
        reverse(arr, m + 1, j - 1);

        // reverse arr[i..j-1]
        reverse(arr, i, j - 1);
    }

    // Function to Rearrange positive and
    // negative numbers in an array
    static void RearrangePosNeg(int arr[], int l, int r) {
        if (l < r) {
            // Same as (l+r)/2, but avoids overflow for
            // large l and r
            int m = l + (r - l) / 2;

            // Sort first and second halves.
            RearrangePosNeg(arr, l, m);
            RearrangePosNeg(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    // Driver Code
    public static void main(String[] args) {
        int arr[] = { -12, 11, -13, -5, 6, -7, 5, -3, -6 };
        int arr_size = arr.length;
        RearrangePosNeg(arr, 0, arr_size - 1);
        printArray(arr, arr_size);
    }
}

// Time Complexity is O(nlogn).
