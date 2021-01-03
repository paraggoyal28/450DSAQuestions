Given an array and a number k where k is smaller than the size of the array, we need to find the kth smallest element in the given array. It is given that all array elements are distinct.
Examples:
Input: arr[] = {7, 10, 4, 3, 20, 15}
k = 3
Output: 7
Input: arr[] = {7, 10, 4, 3, 20, 15}
k = 4
Output: 10

Method 1(Simple Solution)
A simple solution is to sort the given array using a O(N LogN) sorting algorithm like Merge sort, Heap Sort, etc and return the element at index k - 1 in the sorted array.
Time complexity of this solution is O(N LogN).

Method 2(Using Min Heap - HeapSelect)
We can find k'th smallest element in time complexity better than O(N log N). A Simple
optimization is to create a Min Heap of the given n elements and call extractMin() k times.
Time Complexity O(k*logn + n);

Method 3(Using Max Heap)
We can also use Max Heap for finding the kth smallest element. Following is the 
algorithm.
1. Build a Max-Heap MH of the first k elements(arr[0] to arr[k-1]) of the given array.
O(k)
2. For each element, after the kth element(arr[k] to arr[n-1]), compare it with the root of MH.
......a) If the element is less than the root, then make it root, and call heapify for MH
......b) Else ignore it.
// The step 2 is O((n-k)*logk).

3) Finally, root of the MH is the kth smallest element.
Time complexity of this solution is O(k + (n-k) * logk).

4) QuickSelect
This is an optimization over method 1 if QuickSort is used as a sorting 
algorithm in first step. In QuickSort, we pick a pivot element, then move the pivot element to its correct position and partition the array around it. The idea is, not to do complete quicksort, but stop at the point, where pivot itself is kth smallest element. Also, not to recur for both left and right sides of pivot, but recur for one of them according to the position of pivot. The worst case time complexity of this method is O(n2), but it works in O(n) on average.

5) Randomized QuickSort
It is mainly an extension of QuickSelect. The idea is to randomly pick a pivot element. To implement randomized partition, we use a random function, rand() to generate the index between l and r, swap the element at randomly generated index with the last element, and finally call the standard partition process which uses last element as pivot.

6) Worst case Linear Time 
The idea in this new method is similar to quickSelect(), we get worst-case linear time by selecting a pivot that divides array in a balanced way (there are not very few elements on one side and many on the another side). After the array is divided in a balanced way, we apply the same steps as used in quickSelect() to decide whether to go left or right of the pivot.
Following is complete algorithm:
kthSmallest(arr[0..n-1], k)
1. Divide arr[] into [n/5] groups where size of each group is 5 except possibly the last group which may have less than 5 elements.
2. Sort the above created [n/5] groups and find median of all groups. Create an auxiliary array 'median[]' and store medians of all [n/5] groups in this median array.
// Recursively call this method to find median of medians[0...[n/5]-1].
3) medOfMed = kthSmallest(median[0...[n/5]-1], [n/10])

4) Partition arr[] around medOfMed and obtain its position.
pos = partition(arr, n, medOfMed);

5) if pos == k return medOfMed;
6) if pos > k return kthSmallest(arr[l...pos-1], k);
7) if pos < k return kthSmallest(arr[pos + 1...r], k - pos + l - 1)

