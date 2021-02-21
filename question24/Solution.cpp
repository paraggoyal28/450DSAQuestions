#include <bits/stdc++.h>
using namespace std;

int findLongestConseqSubseq(int arr[], int N)
{
    unordered_set<int> uniq;
    for (int i = 0; i < N; ++i)
    {
        uniq.insert(arr[i]);
    }

    int maxSize = 0;
    unordered_set<int> visited;
    for (int i = 0; i < N; ++i)
    {
        if (visited.find(arr[i]) == visited.end())
        {
            int t = arr[i];
            int count = 0;
            queue<int> q;
            q.push(t);
            visited.insert(t);
            while (!q.empty())
            {
                int top = q.front();
                q.pop();
                count++;
                if (uniq.find(top - 1) != uniq.end() &&
                    visited.find(top - 1) == visited.end())
                {
                    visited.insert(top - 1);
                    q.push(top - 1);
                }
                if (uniq.find(top + 1) != uniq.end() &&
                    visited.find(top + 1) == visited.end())
                {
                    visited.insert(top + 1);
                    q.push(top + 1);
                }
            }
            maxSize = max(maxSize, count);
        }
    }
    return maxSize;
}