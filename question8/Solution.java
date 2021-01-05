package question8;

public class Solution {
    static int maxSubarraySum(int arr[], int n) {
        int maxSumTotal = arr[0];
        int maxSumCurrent = arr[0];
        for (int i = 1; i < n; ++i) {
            maxSumCurrent = Math.max(maxSumCurrent + arr[i], arr[i]);
            maxSumTotal = Math.max(maxSumCurrent, maxSumTotal);
        }
        return maxSumTotal;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, -4, 5 };
        int arr_size = 4;
        int maxSumArray = maxSubarraySum(arr, arr_size);
        System.out.println(maxSumArray);
    }

}
