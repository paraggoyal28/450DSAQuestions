Given a dictionary, and two words 'start' and 'target' (both of same length). Find the length of the smallest chain from 'start' to 'target' if it exists, such that adjacent words in the chain only differ by one character and each word in the chain is a valid word, i.e , it exists in the dictionary. It may be assumed that the 'target' word exists in dictionary and length of all dictionary words is same.
Input:  Dictionary = { POON, PLEE, SAME, POIE, PLEA, PLIE, POIN }
start = TOON
target = PLEA
Output: 7
TOON - POON - POIN - POIE - PLIE - PLEE - PLEA

Input: Dictionary = { ABCD, EBAD, EBCD, XYZA }
Start = ABCV
End = EBAD
Output: 4
ABCV - ABCD - EBCD - EBAD

Solution: The idea is to use BFS.
