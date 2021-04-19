package question13;

public class Solution {
    int maxSubarraySum(int arr[], int n) {
        int maxTotal = 0;
        int maxCurrent = 0;
        for (int i = 0; i < n; ++i) {
            maxCurrent = Math.max(arr[i] + maxCurrent, arr[i]);
            maxTotal = Math.max(maxCurrent, maxTotal);
        }
        return maxTotal;
    }
}
