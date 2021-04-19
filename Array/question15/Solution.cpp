#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    void nextPermutation(vector<int> &nums)
    {
        int start = -1;
        for (int i = nums.size() - 2; i >= 0; --i)
        {
            if (nums[i] < nums[i + 1])
            {
                start = i;
                break;
            }
        }
        int minElem = INT_MAX;
        int minElemIndex = 0;
        if (start != -1)
        {
            for (int i = start + 1; i < nums.size(); ++i)
            {
                if (nums[i] > nums[start] && nums[i] < minElem)
                {
                    minElem = nums[i];
                    minElemIndex = i;
                }
            }
            swap(nums[start], nums[minElemIndex]);
        }
        sort(nums.begin() + start + 1, nums.end());
    }
};