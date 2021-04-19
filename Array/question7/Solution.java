package question7;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        while (tests != 0) {
            int n = sc.nextInt();
            int[] numArray = new int[n];
            for (int i = 0; i < n; ++i) {
                numArray[i] = sc.nextInt();
            }
            System.out.print(numArray[n - 1] + " ");
            for (int i = 0; i < n - 1; ++i) {
                System.out.print(numArray[i] + " ");
            }
            System.out.println();
            tests = tests - 1;
        }
    }
}
