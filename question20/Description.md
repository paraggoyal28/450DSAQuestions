Rearrange array in alternating positive & negative items with O(1) space | Set 1
Given an array of positive and negative numbers, arrange them in an alternative fashion such that every positive number is followed by a negative and vice-versa maintaining the order of appearance.
Number of positive and negative numbers need not be equal. If there are more positive numbers they appear at the end of the array. If there are more negative numbers, they too appear in the end of the array.
Examples: 
Input: arr[] = {1, 2, 3, -4, -1, 4}
Output: arr[] = {-4, 1, -1, 2, 3, 4}
Input: arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
Output: arr[] = {-5, 5, -2, 2, -8, 4, 7, 1, 8, 0}

The idea is to process the array and shift all negative elements to the end in O(n) time. After all the negative values are shifted to the end, we can easily rearrange array in alternating positive and negative items. We basically swap next positive element at the even position from next negative element from the end.
