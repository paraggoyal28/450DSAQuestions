Given a sequence of words, and a limit on the number of characters that can be put in one line(line width).
Put line breaks in the given sequence such that the lines are printed neatly.
Assume that the length of each word is less than the line width.
The word processors like the MS Word do task of placing line breaks. The idea is to have balanced lines. In other words, not have few lines with lots of extra spaces and some lines with small amount of extra spaces.
The extra spaces includes spaces put at the end of every line except the last one.
The problem is to minimize the following total cost.
For example, consider the following string and line width M = 15 "Geeks for Geeks presents Word wrap problem"
Following is the optimized arrangement of the words in 3 lines.
Geeks for geeks
presents word
wrap problem
The total extra spaces in line 1, line 2, and line 3 are 0, 2 and 3 respectively.
So optimal total cost is 0 + 2*2 +  3*3 = 13.
Please note that the total cost function is not sum of extra spaces, but sum of cubes(or squares) of extra spaces. The idea behind this cost function is to balance the spaces among lines. For example, consider the following two arrangements of same set of words.
1. There are 3 lines. One line has 3 extra spaces and all other lines have 0 extra spaces. Total extra spaces = 3.
Total cost = 3 * 3 + 0 * 0 + 0 * 0 = 9.
2. There are 3 lines. Each of the 3 lines have one extra space. Total extra spaces = 1 * 1 + 1 * 1 + 1 * 1 = 3.
Total extra spaces are 3 in both scenarios, but second arrangement should be preferred because extra spaces are balanced in all three lines. The cost function with cubic sum serves the purpose because the value of total cost in second scenario is less.

Method 1(Greedy Solution)
The greedy solution is to place as many words as possible in the first line. Then do the same thing for the second line and so on until all words are placed. This solution gives the optimal solution for many cases, but does n't give the optimal solution in all cases. For example, consider the following string "aaa bb cc ddddd" and line width as 6. Greedy method would produce.
aaa bb
cc
ddddd
Extra spaces in the above 3 lines are 0, 4 and 1, respectively. So total cost is 0 + 16 + 1 = 17. But the above solution is not the best one. Following arrangement has more balanced spaces. Therefore less value of the total cost function.
aaa
bb cc
ddddd
Extra space is 3 + 1 + 1 = 5. Cost is 9 + 1 + 1 = 11.
Despite being sub-optimal in some cases, the greedy approach is used by many word processors(like MS Word and Open Office.org Writer).

Method 2(Dynamic Programming)
The following dynamic programming approach strictly follows the algorithm given in the solution of Cormen book. First we compute the costs of all possible lines in a 2D table lc[][]. The value lc[i][j] indicates the cost to put the words from i to j in a single line where i and j are indices of words in the input sequences. If a sequence of words from i to j cannot fit in a single line, then lc[i][j] is considered infinite.Once we have the lc[][] table constructed, we can calculate total cost using following recursive formula. In the following formula, C[j] is the optimized total cost for arranging the words from 1 to j.
c[j] = {
    0,  if j = 0
    min(c[i-1] + lc[i, j]) if j > 0
}

The above recursion has overlapping subproblem property. For example, the solution of subproblem c(2) is used by c(3), c(4) and so on. So Dynamic Programming is used to store the results of the subproblems. The array c[] can be computed from left to right, since each value depends on the earlier values.
To print the output, we keep track of what words go on what lines, we can keep a parallel p array that points to where each c value comes from. The last line starts at word p[n] and goes through word n. The previous line starts at word p[p[n]] and goes through word p[n] - 1, etc. The function printSolution() uses p[] to print the solution. In the below program, input is an array l[] that represents the lengths of words in a sequence. The value l[i] indicates the length of the ith word (i starts from 1) in the input sequence.
