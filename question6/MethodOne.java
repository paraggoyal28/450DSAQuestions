package question6;

import java.util.*;

public class MethodOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        while (tests != 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] firstArray = new int[n];
            int[] secondArray = new int[m];
            HashSet<Integer> uniqueElements = new HashSet<Integer>();
            for (int i = 0; i < n; ++i) {
                firstArray[i] = sc.nextInt();
                uniqueElements.add(firstArray[i]);
            }
            for (int i = 0; i < m; ++i) {
                secondArray[i] = sc.nextInt();
                uniqueElements.add(secondArray[i]);
            }
            System.out.println(uniqueElements.size());
            tests = tests - 1;
        }
        sc.close();
    }
}
