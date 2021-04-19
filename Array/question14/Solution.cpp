#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    static bool cmp(vector<int> a, vector<int> b)
    {
        if (a[0] == b[0])
        {
            return a[1] < b[1];
        }
        return a[0] < b[0];
    }
    vector<vector<int>> merge(vector<vector<int>> &intervals)
    {
        if (intervals.size() == 1)
        {
            return intervals;
        }
        sort(intervals.begin(), intervals.end(), cmp);
        bool overlap = false;
        vector<vector<int>> sol;
        int n = intervals.size();
        for (int i = 0; i < n - 1; ++i)
        {
            vector<int> interval(2);
            int start;
            int flag = 0;
            if (intervals[i][1] >= intervals[i + 1][0])
            {
                overlap = true;
                flag = 1;
                interval[0] = min(intervals[i][0], intervals[i + 1][0]);
                interval[1] = max(intervals[i][1], intervals[i + 1][1]);
            }
            else
            {
                interval = intervals[i];
            }
            while (overlap && i < n)
            {
                if (intervals[i][0] > interval[1])
                {
                    overlap = false;
                }
                else
                {
                    interval[1] = max(intervals[i][1], interval[1]);
                    i++;
                }
            }
            if (flag == 1)
            {
                i--;
            }
            sol.push_back(interval);
        }
        if (sol.size() >= 1 && sol.back()[1] < intervals[n - 1][0])
        {
            sol.push_back(intervals[n - 1]);
        }
        return sol;
    }
};