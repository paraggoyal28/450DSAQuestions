class Solution
{
public:
    int max(int a, int b)
    {
        if (a > b)
        {
            return a;
        }
        else
        {
            return b;
        }
    }
    void merge(int arr1[], int arr2[], int n, int m)
    {
        int mx = 0;
        for (int i = 0; i < n; ++i)
        {
            mx = max(mx, arr1[i]);
        }
        for (int i = 0; i < m; ++i)
        {
            mx = max(mx, arr2[i]);
        }
        mx++;
        int i = 0, j = 0, k = 0;
        while (i < n && j < m && k < (n + m))
        {
            // recover back the original elements
            int e1 = arr1[i] % mx;
            int e2 = arr2[i] % mx;

            if (e1 <= e2)
            {
                if (k < n)
                {
                    arr1[k] += e1 * mx;
                }
                else
                {
                    arr2[k - n] += e1 * mx;
                }
                i++;
                k++;
            }
            else
            {
                if (k < n)
                {
                    arr1[k] += e2 * mx;
                }
                else
                {
                    arr2[k - n] += e2 * mx;
                }
                j++;
                k++;
            }
        }
        while (i < n)
        {
            int e1 = arr1[i] % mx;
            if (k < n)
            {
                arr1[k] += e1 * mx;
            }
            else
            {
                arr2[k - n] += e1 * mx;
            }
            i++;
            k++;
        }
        while (j < m)
        {
            int e2 = arr2[j] % mx;
            if (k < n)
            {
                arr2[k] += e2 * mx;
            }
            else
            {
                arr2[k - n] += e2 * mx;
            }
        }
        for (int i = 0; i < n; ++i)
        {
            arr1[i] = arr1[i] / mx;
        }
        for (int j = 0; j < m; ++j)
        {
            arr2[j] = arr2[j] / mx;
        }
    }
};