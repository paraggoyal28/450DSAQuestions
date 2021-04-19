#include <bits/stdc++.h>
using namespace std;

bool isCyclicUtil(int v, bool visited[], bool *recStack, vector<int> adj[])
{
    if (visited[v] = false)
    {
        visited[v] = true;
        recStack[v] = true;

        vector<int>::iterator itr;
        for (itr = adj[v].begin(); itr != adj[v].end(); ++itr)
        {
            if (!visited[*itr] && isCyclicUtil(*itr, visited, recStack, adj))
            {
                return true;
            }
            else if (recStack[*itr])
            {
                return true;
            }
        }
    }
    recStack[v] = false;
    return false;
}

bool isCyclic(int V, vector<int> adj[])
{
    bool *visited = new bool[V];
    bool *recStack = new bool[V];
    for (int i = 0; i < V; ++i)
    {
        visited[i] = false;
        recStack[i] = false;
    }

    // Call the recursive helper function to detect cycle in different
    // DFS trees
    for (int i = 0; i < V; ++i)
        if (isCyclicUtil(i, visited, recStack, adj))
            return true;

    return false;
}

// TC:O(V+E)
// SC:O(V) Recusion Stack