import java.util.*;

public class BOJ_2579{
    static int[] dp, stair;
    public static void main(String[] args){
        Scanner scan= new Scanner(System.in);
        int n = scan.nextInt();


        stair = new int[n+2];
        for(int i=1; i<=n; i++){
            stair[i]=scan.nextInt();
        }

        dp = new int[n+2];
        dp[1]=stair[1];
        dp[2]=stair[2]+stair[1];

        for(int i=3; i<=n; i++){
            dp[i]=Math.max(dp[i-3]+stair[i-1], dp[i-2])+stair[i];
        }
        System.out.println(dp[n]);
    }
}