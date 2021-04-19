from itertools import accumulate, combinations
from collections import Counter


class Solution:
    def numSubmatrixSumTarget(self, matrix, target):
        m, n = len(matrix), len(matrix[0])
        dp, ans = {}, 0
        for k in range(m):
            t = [0] + list(accumulate(matrix[k]))
            for i, j in combinations(range(n+1), 2):
                dp[i, j, k] = dp.get((i, j, k-1), 0) + t[j] - t[i]

        for i, j in combinations(range(n+1), 2):

            T = Counter([0])
            for k in range(m):
                ans += T[dp[i, j, k] - target]
                if(T[dp[i, j, k] - target] > 0):
                    print(i, j, k)
                    print(T[dp[i, j, k]])
                    print(dp[i, j, k])
                T[dp[i, j, k]] += 1
        return ans


if __name__ == "__main__":
    matrix = [[1, 2, 3], [2, 3, 4], [2, 4, 4]]
    target = 5
    s = Solution()
    print(s.numSubmatrixSumTarget(matrix, target))
