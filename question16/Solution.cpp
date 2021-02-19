#include <bits/stdc++.h>
using namespace std;

long long merge(long long arr[], long long start, long long mid, long long end)
{
    long long left = start;
    long long right = mid;
    long long inversions = 0;
    vector<long long> temp;
    while (left < mid && right <= end)
    {
        if (arr[left] <= arr[right])
        {
            temp.push_back(arr[left]);
            left++;
        }
        else
        {
            inversions += mid - left;
            temp.push_back(arr[right]);
            right++;
        }
    }
    while (left < mid)
    {
        temp.push_back(arr[left]);
        left++;
    }
    while (right <= end)
    {
        temp.push_back(arr[right]);
        right++;
    }
    for (long long iter = start; iter <= end; ++iter)
    {
        arr[iter] = temp[iter - start];
    }
    return inversions;
}

long long mergeSort(long long arr[], long long start, long long end)
{
    long long inversions = 0;
    if (start < end)
    {
        long long mid = start + (end - start) / 2;
        inversions += mergeSort(arr, start, mid);
        inversions += mergeSort(arr, mid + 1, end);
        inversions += merge(arr, start, mid + 1, end);
    }
    return inversions;
}

long long int inversionCount(long long arr[], long long N)
{
    return mergeSort(arr, 0, N - 1);
}