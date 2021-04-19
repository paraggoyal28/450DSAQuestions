package question9;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static int getMinDiff(int[] arr, int n, int k) {
        if (n == 1) {
            return 0;
        }

        // Sort all the elements
        Arrays.sort(arr);

        // Initialize result
        int ans = arr[n - 1] - arr[0];

        // Handle corner cases
        int small = arr[0] + k;
        int big = arr[n - 1] - k;
        int temp = 0;

        if (small > big) {
            temp = small;
            small = big;
            big = temp;
        }

        // Traverse middle elements
        for (int i = 1; i < n - 1; ++i) {
            int subtract = arr[i] - k;
            int add = arr[i] + k;

            // If both subtraction and addition
            // donot change diff
            if (subtract >= small || add <= big) {
                continue;
            }

            // Either subtraction causes a smaller number
            // or addition causes a greater number. Update
            // small or big using greedy approach (If big - subtract)
            // causes smaller diff, update small else update big.
            if (big - subtract <= add - small) {
                small = subtract;
            } else {
                big = add;
            }
        }
        ans = Math.min(ans, big - small);
        return ans;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int arr_size = sc.nextInt();
        int[] arr = new int[arr_size];
        for (int i = 0; i < arr_size; ++i) {
            arr[i] = sc.nextInt();
        }
        int minimumDifference = getMinDiff(arr, arr_size, K);
        System.out.println("Min Difference Of greatest and least height " + minimumDifference);
        sc.close();
    }
}
