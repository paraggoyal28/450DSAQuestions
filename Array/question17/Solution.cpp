#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int maxProfit(vector<int> &prices)
    {
        int curMax = 0;
        int totalMax = 0;
        for (int i = 0, n = prices.size(); i < n - 1; ++i)
        {
            curMax = max(curMax + prices[i + 1] - prices[i], prices[i + 1] - prices[i]);
            totalMax = max(totalMax, curMax);
        }
        return totalMax;
    }
};