package question10;

public class Solution {
    // Returns the minimum number
    // of jumps to reach arr[h] from arr[l]
    static int minJumps(int arr[], int l, int h) {
        // Base Case: When source and destination are same
        if (h == l) {
            return 0;
        }

        // When nothing is reachable from the given source
        if (arr[l] == 0) {
            return Integer.MAX_VALUE;
        }

        // Traverse through all the points reachable from arr[i].
        // Recursively get the minimum number of jumps
        // needed to reach arr[h] from these reachable points.
        int min = Integer.MAX_VALUE;
        for (int i = l + 1; i <= h && i <= l + arr[l]; ++i) {
            int jumps = minJumps(arr, i, h);
            if (jumps != Integer.MAX_VALUE && jumps + 1 < min) {
                min = jumps + 1;
            }
        }
        return min;
    }

    // Driver Code
    public static void main(String args[]) {
        int arr[] = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 };
        int n = arr.length;
        System.out.print("Minimum number of jumps to reach end is " + minJumps(arr, 0, n - 1));
    }
}

// Complexity Analysis:
// Time complexity: O(n^n)
/*
 * There are maximum n possible ways to move from a element. So maximum number
 * of steps can be N^N so the upperbound of time complexity is O(N^N). Auxiliary
 * Space: O(1) There is no space required (if recursive stack space is ignored).
 * Note: If the execution is traced for this method, it can be seen that there
 * will be overlapping subproblems. For example, minJumps(3, 9) will be called
 * two times as arr[3] is reachable from arr[1] and arr[2]. So this problem has
 * both properties (optimal substructure and overlapping subproblems) of Dynamic
 * Programming.
 * 
 * 
 */
