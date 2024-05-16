import java.util.Scanner;

public class MaxMinArray {
    static int[] a;
    static int max, min;

    static void maxmin(int i, int j) {
        int max1, min1, mid;
        if (i == j) {
            max = min = a[i];
        } else {
            if (i == j - 1) {
                if (a[i] < a[j]) {
                    max = a[j];
                    min = a[i];
                } else {
                    max = a[i];
                    min = a[j];
                }
            } else {
                mid = (i + j) / 2;
                maxmin(i, mid);
                max1 = max;
                min1 = min;
                maxmin(mid + 1, j);
                if (max < max1)
                    max = max1;
                if (min > min1)
                    min = min1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the total number of numbers : ");
        int num = scanner.nextInt();
        a = new int[num];
        System.out.println("Enter the numbers : ");
        for (int i = 0; i < num; i++)
            a[i] = scanner.nextInt();

        max = a[0];
        min = a[0];

        maxmin(0, num - 1);
        System.out.println("Minimum element in the array : " + min);
        System.out.println("Maximum element in the array : " + max);
    }
}




