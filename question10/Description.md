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

Method 4
Time Complexity: O(n) solution
Space Complexity: O(1) solution
Implementation:
Variables to be used:
1. maxReach: The variable maxReach stores at all time the maximal reachable index 
in the array
2. step: The variable step stores the number of steps we can still take (and is
intialized with value at index 0, i.e initial number if steps)
3. jump: Jump stores the amount of jumps necessary to reach that maximal reachable position.

Given array arr = 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9
maxReach = arr[0]; // arr[0] = 1, so the maximum index we can reach at the moment is 1.
step = arr[0]; // arr[0] = 1, the amount of steps we can still take is also 1.
jump = 1; // we will always need to take at least one jump.

Now, starting iteration from index 1, the above values are updated as follows:
1. First we test whether we have reached the end of the array, in that case we just need to return the jump variable.
if(i==arr.length - 1)
    return jump;
2. Next we update the maxReach.This is equal to the maximum of maxReach and i  + arr[i] (the number of steps we can take from the current position).
maxReach = Math.max(maxReact, i + arr[i]);

3. We used up a step to get to the current index, so steps has to be decreased.
step--;

4. If no more steps are remaining(i.e steps = 0, then we must have used a jump.
Therefore increase jump. Since we know that it is possible somehow to react maxReach, we again initialize the steps to the number of steps to reach maxReach 
from position i. But before re-initializing step, we also check whether a step is
 becoming zero or negative.) In this case, it is not possible to reach further.

if(step == 0){
    jump++;
    if(i >= maxReach)
        return -1;
    step = maxReach - i;
}

