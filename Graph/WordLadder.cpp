/**A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 */
#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int ladderLength(string beginWord, string endWord, vector<string> &wordList)
    {
        unordered_set<string> uniq;
        for (int i = 0; i < wordList.size(); ++i)
        {
            uniq.insert(wordList[i]);
        }
        queue<pair<string, int>> start;
        start.push({beginWord, 1});
        unordered_set<string> visited;
        while (!start.empty())
        {
            pair<string, int> startTop = start.front();
            start.pop();
            visited.insert(startTop.first);
            if (startTop.first == endWord)
            {
                return startTop.second;
            }
            string a = startTop.first;
            for (int i = 0; i < a.length(); ++i)
            {
                char org = a[i];
                for (char ch = 'a'; ch <= 'z'; ++ch)
                {
                    a[i] = ch;
                    if (uniq.find(a) != uniq.end() && visited.find(a) == visited.end())
                    {
                        visited.insert(a);
                        start.push({a, startTop.second + 1});
                    }
                }
                a[i] = org;
            }
        }
        return 0;
    }
};