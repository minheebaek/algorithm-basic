import java.util.*;

public class Main{
    static int dp[][], stiker[][];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        for(int i=0; i<t; i++){
            int n = scan.nextInt();

            dp = new int[2][n+1];
            stiker = new int[2][n+1];

            for(int j=0; j<2; j++){
                for(int k=1; k<=n; k++) {
                    stiker[j][k]=scan.nextInt();
                }
            }

            dp[0][1]=stiker[0][1];
            dp[1][1]=stiker[1][1];

            for(int k=2; k<=n; k++) {
                dp[0][k]=Math.max(dp[1][k-1],dp[1][k-2])+stiker[0][k];
                dp[1][k]=Math.max(dp[0][k-1],dp[0][k-2])+stiker[1][k];
            }

            System.out.println(Math.max(dp[0][n],dp[1][n]));

        }
    }
}