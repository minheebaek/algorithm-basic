import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int ans =0;

        boolean[][] check = new boolean[201][201];
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            check[a][b]=check[b][a]=true;

        }

        for(int i=1;i<=n;i++){
            for(int j=i+1;j<=n;j++){
                for(int k=j+1;k<=n;k++){
                    if(check[i][j]||check[i][k]||check[j][k]) continue;
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}