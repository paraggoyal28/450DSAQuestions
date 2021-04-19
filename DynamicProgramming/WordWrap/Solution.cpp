#include <bits/stdc++.h>
using namespace std;
#define INF INT_MAX

// A utility function to print the solution
int printSolution(int p[], int n);

// l[] represents lengths of different words in input sentence.
// For example, l[] = {3, 2, 2, 5} is for a sequence like
// "aaa bb cc ddddd". n is the size of the l[] and M is the line width
// (maximum number of characters that can fit in the line).
void solveWordWrap(int l[], int n, int M)
{

    //extras[i][j] will have number of extra spaces if words from i to j
    // are put in a single line.
    int extras[n + 1][n + 1];

    // lc[i][j] will have cost of a line which has words from i to j.
    int lc[n + 1][n + 1];

    // c[i] will have total cost of optimal arrangements of the words from
    // 1 to i.
    int c[n + 1];

    // p[] is used to print the solution.
    int p[n + 1];

    int i, j;

    // calculate the extra spaces in a single line. The value extras[i][j]
    // indicates extra spaces if words from word number i to j are placed in a single line
    for (i = 1; i <= n; ++i)
    {
        extras[i][i] = M - l[i - 1];
        for (j = i + 1; j <= n; ++j)
        {
            extras[i][j] = extras[i][j - 1] - l[j - 1] - 1;
        }
    }

    // Calculate line cost corresponding to the above calculated extra spaces. The value
    // lc[i][j] indicates cost of putting words from word number i to word number j in a single line
    for (i = 1; i <= n; ++i)
    {
        for (j = i; j <= n; ++j)
        {
            if (extras[i][j] < 0)
            {
                lc[i][j] = INF;
            }
            else if (j == n && extras[i][j] >= 0)
            {
                lc[i][j] = 0;
            }
            else
            {
                lc[i][j] = extras[i][j] * extras[i][j];
            }
        }
    }

    // Calculate minimum cost and find minimum cost arrangement
    c[0] = 0;
    for (int j = 1; j <= n; ++j)
    {
        c[j] = INF;
        for (int i = 1; i <= j; ++i)
        {
            if (c[i - 1] != INF && lc[i][j] != INF && c[i - 1] + lc[i][j] < c[j])
            {
                c[j] = c[i - 1] + lc[i][j];
                p[j] = i;
            }
        }
    }

    printSolution(p, n);
}

int printSolution(int p[], int n)
{
    int k;
    if (p[n] == 1)
    {
        k = 1;
    }
    else
    {
        k = printSolution(p, p[n] - 1) + 1;
    }
    cout << "Line number " << k << " : From Word no. " << p[n] << " to " << n << endl;
    return k;
}

int main()
{
    int l[] = {3, 2, 2, 5};
    int n = 4;
    int M = 6;
    solveWordWrap(l, n, M);
    return 0;
}