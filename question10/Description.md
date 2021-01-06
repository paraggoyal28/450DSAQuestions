Given an array of integers where each element represents the max number of steps that can be made forward from that element. Write a function to return the minimum number of jumps to reach the end of the array(starting from the first element). If the element is 0, they cannot move through that element.
Examples:
Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
Output: 3 (1 -> 3 -> 8 -> 9)
Explanation: Jump from 1st element to 2nd element as there is only 1 step, now there are three options, 5, 8 or 9. If 8 or 9 is chosen then the end node 9 can be reached. So 3 jumps are made.

Input: arr[] = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
Output: 10
Explanation: In every step a jump is needed so the count of jumps is 10

Method 2:
Dynamic Programming
Approach:
1. In this way, make a jumps[] array from left to right such that jumps[i] indicate the minimum number of jumps needed to reach arr[i] from arr[0].
2. To fill the jumps array run a nested loop inner loop counter is j and outer loop 
counter is i.
3. Outer loop from 1 to n-1 and inner loop from 0 to n-1.
4. If i is less than j+arr[j] then set jumps[i] to minimum of jumps[i] and jumps[j] + 1. Initially set jumps[i] to INT MAX.
5. Finally, return jumps[n-1].
