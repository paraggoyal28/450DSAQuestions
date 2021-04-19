package question20;

class GFG {
    static void rearrange(int arr[], int n) {
        int i = 0, j = n - 1;
        // shift all the negative values to the end
        while (i < j) {
            while (i <= n - 1 && arr[i] > 0) {
                i += 1;
            }
            while (j >= 0 && arr[j] < 0) {
                j -= 1;
            }
            if (i < j)
                swap(arr, i, j);
        }

        // i has the index of leftmost negative element
        if (i == 0 || i == n) {
            return;
        }

        // start with first positive element at the start of the array
        int k = 0;
        while (k < n && i < n) {
            swap(arr, k, i);
            k += 2;
            i += 1;
        }
    }

    // swap function
    static void swap(int arr[], int index1, int index2) {
        int c = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = c;
    }

    // print function
    static void printArray(int arr[], int n) {
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String args[]) {
        int arr[] = { 2, 3, -4, -1, 6, -9 };
        int n = arr.length;

        System.out.println("Given array is ");
        printArray(arr, n);

        rearrange(arr, n);

        System.out.println("Rearranged array is ");
        printArray(arr, n);
    }
}
