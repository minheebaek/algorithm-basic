package 알고리즘.BOJ;


import java.util.Scanner;

public class BOJ_11726 {
    public static int[] d;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        d = new int[n + 1];
        d[0] = 1;
        d[1] = 2;

        for (int i = 2; i < n; i++) {
            d[i] = (d[i - 1] + d[i - 2]) % 10007;
        }

        System.out.println(d[n - 1]);
    }
}

