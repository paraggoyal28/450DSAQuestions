Move all the negative numbers to beginning and positive to end with constant 
extra space
An array contains both positive and negative numbers in random order. Rearrange the array elements so that all negative numbers appear before all positive numbers.
Examples:
Input: -12, 11, -13, -5, 6, -7, 5, -3, -6
Output: -12, -13, -5, -7, -3, -6, 11, 6, 5
Note: Order of elements is not important here.
Approach 1:
The idea is to simply apply the partition process of quicksort.


Method 2:
Two Pointer Approach: The idea is to solve this problem with constant space and linear time is by using a two-pointer or two-variable approach where we simply take two variables like left and right which hold the 0 and N-1 indexes. Just need to check that:
1. Check if the left and right pointer elements are negative then simply increment the left pointer.
2. Otherwise, if the left element is positive and the right element is negative then simply swap the elements, and simultaneously increment or decrement the left or right pointers.
3. Else if the left element is positive and the right element is also positive then simply decrement the right pointer.
4. Repeat the above 3 steps until the left pointer <= right pointer.


Method3:
Modified Insertion Sort
We can modify the insertion sort to solve this problem.
Algorithm - 
Loop from i = 1 to n - 1.
a) If the current element is positive, do nothing.
b) If the current element arr[i] is negative, we 
insert it into sequence arr[0...i-1] such that 
all positive elements in arr[0...i-1] are shifted 
one position to their right and arr[i] is inserted
at index of first positive element.
