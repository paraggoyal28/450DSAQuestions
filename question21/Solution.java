package question21;

import java.util.HashSet;

public class Solution {
    boolean subArrayExists(int arr[], int n) {
        int sum = 0;
        HashSet<Integer> summation = new HashSet<Integer>();
        summation.add(0);
        for (int i = 0; i < n; ++i) {
            sum += arr[i];
            if (summation.contains(sum)) {
                return true;
            }
            summation.add(sum);
        }
        return false;
    }
}
