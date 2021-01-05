Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.
Input: 
N = 5
arr[] = {0, 2, 1, 2, 0}
Output: 0 0 1 2 2 
Explanation: 0s 1s and 2s are segregated into ascending order.

N = 3
arr[] = { 0, 1, 0}
Output: 0 0 1

Method 1
Approach: 
This problem is similar to our old post Segregate 0s and 1s in an array, and both of these problems are variations of famous Dutch national flag problem.
The problem was posed with three colours, here '0', '1', and '2'. The array is divided into four sections:
1. a[1..Lo-1] zeroes(red)
2. a[Lo..Mid-1] ones(white)
3. a[Mid..Hi] unknown 
4. a[Hi+1..N] twos(blue)

Dutch National Flag Algorithm OR 3-way Partitioning:
At first, the full array is unknown.There are three indices = low, mid and high. Initially, the value of low = mid = 1 and high = N.
1. If the ith element is 0 then swap the element to the low range, thus shrinking the unknown range.
2. Similarly, if the element is 1 then keep it as it is but shrink the unknown range.
3. If the element is 2 then swap it with an element in high range.
Algorithm:
1. Keep three indices low = 1, mid = 1, and high = N and there are four ranges,1 to low( the range containing 0), low to mid (the range containing 1), mid to high(the range containing unknown elements) and high to N(the range containing 2).
2. Traverse the array from start to end and mid is less than high(Loop counter is i).
3. If the element is 0 then swap the element with the element at index low and update low = low + 1 and mid = mid + 1.
4. If the element is 1, then update mid = mid + 1.
5. If the element is 2 then swap the element with the element at index high and update high = high - 1 and update i = i - 1. As the swapped element is not processed.
6. Print the output array.


