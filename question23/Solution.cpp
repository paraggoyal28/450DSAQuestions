#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    long long maxProduct(int *arr, int n)
    {
        if (n == 0)
        {
            return 0;
        }

        long long minProd = arr[0];
        long long maxProd = arr[0];
        long long totalProd = arr[0];
        for (long long i = 0; i < n; ++i)
        {
            if (arr[i] < 0)
            {
                long long temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }
            maxProd = max((long long)arr[i], maxProd * arr[i]);
            minProd = min((long long)arr[i], minProd * arr[i]);
            totalProd = max(maxProd, totalProd);
        }
        return totalProd;
    }
};