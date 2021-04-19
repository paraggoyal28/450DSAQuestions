We are given two sorted array. We need to merge these two arrays such that the initial numbers (after complete sorting) are in the first array and the remaining numbers are in the second array. Extra space allowed is O(1).
Input:  ar1[] = {10};
        ar2[] = { 2, 3};
Output: ar1[] = {2};
        ar2[] = {3, 10};

Input:  ar1[] = { 1, 5, 9, 10, 15, 20 };
        ar2[] = { 2, 3, 8, 13 };
Output: ar1[] = { 1, 2, 3, 5, 8, 9};
        ar2[] = { 10, 13, 15, 20 };

Method One:
This task is simple and O(m+n) if we are allowed to use extra space. But it becomes really complicated when extra space is not allowed and doesn't look possible in less than O(m*n) worst case time.
The idea is to begin from last element of ar2[] and search it in ar1[]. If there is a greater element in ar1[], then we move last element of ar1[] to ar2[]. To keep ar1[] and ar2[] sorted, we need to place last element of ar2[] at correct place in ar1[]. We can use Insertion sort type for insertion like this.Below is the algorithm:
1) Iterate through every element of ar2[] starting from last element. Do following for every element ar2[i]
    a) Store last element of ar1[i]: last = ar1[i]
    b) Loop from last element of ar1[] while element ar1[j] is 
    greater than ar2[i].
        ar1[j+1] = ar1[j]
        j--;
    c) If any element of ar1[] was moved or (j != m-1)
        ar1[j+1] = ar2[i]
        ar2[i] = last

In above loop, elements in ar1[] and ar2[] are always kept sorted.
Given two sorted arrays, we need to merge them in O((n+m)*log(n+m)) time with O(1) extra space into a sorted array, when n is the size of the first array, and m is the size of the second array.
Example: 
Input:  ar1[] = {10};
        ar2[] = {2, 3};
Output: ar1[] = {2};
        ar2[] = {3, 10};
    
The idea: We start comparing elements that are far from each other rather than adjacent. For every pass, we calculate the gap and compare the elements towards the right of the gap. Every pass, the gap reduces to the ceiling value of dividing by 2.

Another method in O(m+n) time complexity: 
Here we use the below technique:
Suppose we have a number A and we want to convert it to number B and there is also a constraint that we can recover number A any time without using other variable. To achieve this we chose a number N which is greater than both numbers and add B*N into A.
so A --> A + B * N.

To get number B out of (A + B*N)
we divide (A+B*N) by N (A+B*N)/N = B.

To get number A out of (A + B*N)
we take modulo with N (A + B*N) % N = A;

-> In short by taking modulo we get old number back and taking divide we
get new number;

We first find the maximum element of both array and increment it one - to avoid 
collision of 0 and maximum element during modulo operation. The idea is to traverse both arrays from starting simultaneously. Let's say an element in a is
a[i] and in b is b[j] and  k is the position at where the next minimum number should come. Now update 