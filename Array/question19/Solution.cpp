#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    vector<int> commonElements(int A[], int B[], int C[], int n1, int n2, int n3)
    {
        unordered_set<int> uniq;
        unordered_set<int> uniq2;
        unordered_set<int> uniq3;
        for (int i = 0; i < n1; ++i)
        {
            uniq.insert(A[i]);
        }
        for (int i = 0; i < n2; ++i)
        {
            if (uniq.find(B[i]) != uniq.end() && uniq2.find(B[i]) == uniq2.end())
            {
                uniq2.insert(B[i]);
            }
        }
        vector<int> sol;
        for (int i = 0; i < n3; ++i)
        {
            if (uniq2.find(C[i]) != uniq2.end() && uniq3.find(C[i]) == uniq3.end())
            {
                sol.push_back(C[i]);
                uniq3.insert(C[i]);
            }
        }
        return sol;
    }
};