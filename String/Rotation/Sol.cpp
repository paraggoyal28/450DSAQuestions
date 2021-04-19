#include <bits/stdc++.h>
using namespace std;

bool areRotations(string a, string b)
{
    if (a.length() != b.length())
    {
        return false;
    }
    string temp = a + a;
    return temp.find(b) != string::npos;
}

int main()
{
    string str1 = "AACD", str2 = "ACDA";
    if (areRotations(str1, str2))
    {
        cout << "Strings are rotations of one another" << endl;
    }
    else
    {
        cout << "String are not rotations of one another" << endl;
    }
}