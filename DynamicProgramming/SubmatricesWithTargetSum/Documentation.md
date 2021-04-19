Given a matrix and a target, return the number of non-empty submatrices that sum to target.
A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x <= x2 and y1 <= y <= y2. 
Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if they have same coordinate that is different: for example, if x1!=x1'.
Example:
0 1 0
1 1 1
0 1 0
Input: matrix = [[0, 1, 0], [1, 1, 1], [0, 1, 0]], target = 0
Output: 4
Explanation: The four 1X1 submatrices that only contain 0.

Solution Approach: 
Let us define by dp[i, j, k] sum of numbers in the rectangle i <= x  < j  and 0 <= y < m. Why it is enough to evaluate only values on these matrices?  Because then we can use 2Sum problem: any sum of elements in submatrix with coordinates a <= x < b and c <= y < d can be evaluated as difference between sum of a <= x < b, 0 <= y < d and sum of a <= x < b, 
0 <= y < c. So, let us fix a and b, and say we have sums S1, S2,..., Sm.
Then we want to find how many differences between these values gives us our target. The idea is to calculate cumulative sums and keep counter of values, and then check how many we have (we cannot use sliding window, because we can have negative values), see problem.
So, we have in total two stages of our algorithm:
1. Precompute all sums in rectangles of the type i <= x < j and 0 <= y < m.
2. For each n*(n-1)/2 problems with fixed i and j, solve the subproblem in O(m) time.
Complexity: 
TC: O((n^2)*m).
SC: O(n^3).

