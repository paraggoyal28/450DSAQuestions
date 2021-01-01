package question1;

import java.util.Scanner;

public class solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int noOfItems = sc.nextInt();
        int[] items = new int[noOfItems];
        for (int i = 0; i < noOfItems; ++i) {
            int item = sc.nextInt();
            items[i] = item;
        }
        sc.close();
        for (int i = noOfItems - 1, j = 0; j < i; --i, j++) {
            int temp = items[i];
            items[i] = items[j];
            items[j] = temp;
        }

        for (int i = 0; i < noOfItems; ++i) {
            System.out.print(items[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
}