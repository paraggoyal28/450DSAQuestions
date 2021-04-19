package question3;

// Java program to find kth smallest element in expected linear time.
public class MethodFive {
    // This function returns kth smallest element in arr[l..r]
    // using QuickSort based method. ASSUMPTION: ALL ELEMENTS
    // IN ARR[] ARE DISTINCT.
    int kthSmallest(int arr[], int l, int r, int k) {
        // If k is smaller than the number of elements in array
        if (k > 0 && k <= r - l + 1) {
            // Partition the array around a random element and
            // get a position of pivot element in sorted array
            int pos = randomPartition(arr, l, r);

            // If position is same as k
            if (pos - l == k - 1) {
                return arr[pos];
            }

            if (pos - l > k - 1) {
                return kthSmallest(arr, l, pos - 1, k);
            }

            // Else recur for right subarray
            return kthSmallest(arr, pos + 1, r, k - pos + l - 1);

        }

        // If k is more than number of elements in array
        return Integer.MAX_VALUE;
    }

    // Utility method to swap arr[i] and arr[j]
    void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Standard partition process of QuickSort().It considers the last element
    // as pivot and moves all smaller element to left of it and greater elements to
    // right. This function is used by randomPartition().

    int partition(int arr[], int l, int r) {
        int x = arr[r], i = l;
        for (int j = l; j <= r - 1; j++) {
            if (arr[j] <= x) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);
        return i;
    }

    // Picks a random pivot element between l and r and partitions
    // arr[l..r] around the randomly picked element using Partition()
    int randomPartition(int arr[], int l, int r) {
        int n = r - l + 1;
        int pivot = (int) (Math.random()) * (n - 1);
        swap(arr, l + pivot, r);
        return partition(arr, l, r);
    }

    public static void main(String args[]) {
        MethodFive ob = new MethodFive();
        int arr[] = { 12, 3, 5, 7, 4, 19, 26 };
        int n = arr.length, k = 3;
        System.out.println("K'th smallest element is " + ob.kthSmallest(arr, 0, n - 1, k));
    }
}

// The expected time complexity is O(n).