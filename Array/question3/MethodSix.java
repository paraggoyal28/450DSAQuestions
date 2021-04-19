package question3;

// java implementation of worst
// case linear time algorithm
// to find kth smallest element
import java.util.*;

public class MethodSix {
    // int partition(int arr[], int l, int r, int k);

    // A simple function to find median of arr[]. This is called
    // only for an array of size 5 in this program.
    static int findMedian(int arr[], int i, int n) {
        if (i <= n) {
            Arrays.sort(arr, i, n); // Sort the array
        } else {
            Arrays.sort(arr, n, i);
        }
        return arr[i + (n - i) / 2];
    }

    // Returns k'th smallest element
    // in arr[l..r] in worst case.
    // linear time. ASSUMPTION: ALL
    // ELEMENTS IN ARR[] ARE DISTINCT
    static int kthSmallest(int arr[], int l, int r, int k) {
        // If k is smaller than the number
        // of elements in array
        if (k > 0 && k <= r - l + 1) {
            int n = r - l + 1; // Number of elements in arr[l..r]

            // Divide arr[] in groups of size 5,
            // calculate the median of every group
            // and store it in median[] array.
            int i;

            // There will be floor((n+4)/5) groups;
            int[] median = new int[(n + 4) / 5];
            for (i = 0; i < n / 5; ++i) {
                median[i] = findMedian(arr, l + i * 5, l + i * 5 + 5);
            }

            // For last group with less than 5 elements
            if (l + i * 5 < n) {
                median[i] = findMedian(arr, l + i * 5, n);
                i++;
            }
            // Find median of all medians using recursive call.
            // If median[] has only one element, then no nedd
            // of recursive call
            int medOfMed = (i == 1) ? median[i - 1] : kthSmallest(median, 0, i - 1, i / 2);

            // Partition the array around a random element and
            // get the position of pivot element in sorted array
            int pos = partition(arr, l, r, medOfMed);

            // If position is same as k
            if (pos - l == k - 1) {
                return arr[pos];
            }
            if (pos - l > k - 1) {
                return kthSmallest(arr, l, pos - 1, k);
            }

            // Else recur for the right subarray
            return kthSmallest(arr, pos + 1, r, k - pos + l - 1);

        }
        return Integer.MAX_VALUE;
    }

    static int[] swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    // It searches for x in arr[l..r], and
    // partitions the array around x
    static int partition(int arr[], int l, int r, int x) {
        // Search for x in arr[l..r] and move it to end
        int i;
        for (i = l; i < r; ++i) {
            if (arr[i] == x) {
                break;
            }
        }
        arr = swap(arr, i, r);

        // Standard partition algorithm
        i = l;
        for (int j = l; j <= r - 1; ++j) {
            if (arr[j] <= x) {
                arr = swap(arr, i, j);
                i++;
            }
        }
        arr = swap(arr, i, r);
        return i;
    }

    // Driver code
    public static void main(String args[]) throws InterruptedException {
        int arr[] = { 12, 3, 5, 7, 4, 19, 26, 76, 1, 34, 15, 16, 78 };
        int n = arr.length;
        for (int k = 1; k <= n; ++k) {
            System.out.println("K is " + k);
            System.out.println("Kth smallest element is " + kthSmallest(arr, 0, n - 1, k));
        }
    }
}
