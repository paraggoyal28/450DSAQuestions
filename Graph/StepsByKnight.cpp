/** Given a square chessboard, the initial position of knight and position of a target. Find out the minimum steps a
 * Knight will take to reach the target position.
 * Node:
 * The initial and the target position coordinates of the Knight have been given according to the 1-base indexing.
 * Example 1:
 * Input: 
 * N=6
 * knightPos = {4, 5}
 * targetPos = {1, 1}
 * Output: 
 * 3
 * expected TC: O(n*n)
 * expected SC: O(n*n)
 * 
 * 
 */
#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int minStepToReachTarget(vector<int> &knightPos, vector<int> &targetPos, int N)
    {
        int x[8] = {-2, -1, -2, -1, 2, 1, 2, 1};
        int y[8] = {-1, -2, 1, 2, -1, -2, 1, 2};
        pair<int, int> p = {knightPos[0], targetPos[0]};
        queue<pair<pair<int, int>, int>> q;
        q.push({p, 0});
        bool visited[N + 1][N + 1];
        memset(visited, false, sizeof(visited));
        while (!q.empty())
        {
            pair<pair<int, int>, int> top = q.front();
            q.pop();
            visited[top.first.first][top.first.second] = true;
            if (top.first.first == targetPos[0] && top.first.second == targetPos[1])
            {
                return top.second;
            }
            for (int i = 0; i < 8; ++i)
            {
                if (top.first.first + x[i] >= 1 && top.first.first + x[i] <= N &&
                    top.first.second + y[i] >= 1 && top.first.second + y[i] <= N &&
                    !visited[top.first.first + x[i]][top.first.second + y[i]])
                {
                    visited[top.first.first + x[i]][top.first.second + y[i]] = true;
                    q.push({{top.first.first + x[i], top.first.second + y[i]}, top.second + 1});
                }
            }
        }
        return -1;
    }
};
