#include <bits/stdc++.h>
using namespace std;
class Solution
{
public:
    int getPairsCount(int arr[], int n, int k)
    {
        unordered_map<int, int> uniq;
        int sum = 0;
        for (int i = 0; i < n; ++i)
        {
            uniq[arr[i]]++;
        }
        for (int i = 0; i < n; ++i)
        {
            sum += uniq[k - arr[i]];
            if (k - arr[i] == arr[i])
            {
                sum -= 1;
            }
        }
        return sum / 2;
    }
};