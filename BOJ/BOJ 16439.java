import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr=new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=m;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int cur=0;
        int ans=0;
        for(int i=1;i<=m;i++){
            for(int j=i+1;j<=m;j++){
                for(int k=j+1;k<=m;k++){
                    cur=0;
                    for(int l=1;l<=n;l++){
                        cur+=Math.max(Math.max(arr[l][i], arr[l][j]),arr[l][k]);
                    }
                    ans=Math.max(ans,cur);
                }
            }
        }


        System.out.println(ans);

    }
}