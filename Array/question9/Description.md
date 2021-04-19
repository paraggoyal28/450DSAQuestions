Given an array arr[] denoting heights of N towers and a positive integer K, we have to modify the height of each tower either by increasing or decreasing them by K only once. After modifying, height should be a non-negative integer. 
Find out what could be the possible minimum difference of height of shortest and longest towers after we have modified each tower.
Example1:
Input:
K = 2, N = 4
Arr[] = { 1, 5, 8, 10}
Output: 5
Explanation: The array can be modified as {3, 3, 6, 8}. The difference between 
the largest and the smallest is 8-3 = 5
Example 2:
K = 3, N = 5
Arr[] =  {3, 9, 12, 16, 20}
Output: 11
Explanation: The array can be modified as { 6, 12, 9, 13, 17 }.
The difference between the largest and the smallest is 17-6 = 11.
Your Task: 
You don't need to read input or print anything. Your task is to complete the function getMinDiff() which takes the arr[], n and k as input parameters and returns an integer denoting the minimum difference.
Expected Time Complexity: O(NLogN).
Expected Auxiliary Space: O(N).
