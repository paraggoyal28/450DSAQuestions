#include <bits/stdc++.h>
using namespace std;

class Node
{
public:
    int val;
    vector<Node *> neighbors;

    Node()
    {
        val = 0;
        neighbors = vector<Node *>();
    }

    Node(int _val)
    {
        val = _val;
        neighbors = vector<Node *>();
    }

    Node(int _val, vector<Node *> _neighbors)
    {
        val = _val;
        neighbors = _neighbors;
    }
};

class Solution
{
public:
    Node *cloneGraph(Node *node)
    {
        if (node == NULL)
        {
            return NULL;
        }
        unordered_map<Node *, Node *> mp;
        queue<Node *> q;
        q.push(node);
        unordered_set<Node *> v;
        v.insert(node);
        while (!q.empty())
        {
            Node *top = q.front();
            q.pop();
            mp[top] = new Node(top->val);
            for (int i = 0; i < top->neighbors.size(); ++i)
            {
                if (v.find(top->neighbors[i]) == v.end())
                {
                    v.insert(top->neighbors[i]);
                    q.push(top->neighbors[i]);
                }
            }
        }
        v.clear();
        v.insert(node);
        q.push(node);
        while (!q.empty())
        {
            Node *top = q.front();
            q.pop();
            for (int i = 0; i < top->neighbors.size(); ++i)
            {
                mp[top]->neighbors.push_back(mp[top->neighbors[i]]);
                if (v.find(top->neighbors[i]) == v.end())
                {
                    v.insert(top->neighbors[i]);
                    q.push(top->neighbors[i]);
                }
            }
        }
        return mp[node];
    }
};