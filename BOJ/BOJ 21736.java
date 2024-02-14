import java.util.*;
import java.io.*;

public class Main{
    static int n,m,ans;
    static int[] dirX={-1,1,0,0};
    static int[] dirY={0,0,-1,1};
    static char[][] gragh;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        gragh=new char[n][m];
        visited=new boolean[n][m];

        int a=0,b=0;
        for(int i=0;i<n;i++){
            String str =br.readLine();
            for(int j=0;j<m;j++){
                gragh[i][j]=str.charAt(j);
                if(gragh[i][j]=='I'){
                    a=i;
                    b=j;
                }
            }
        }
        visited[a][b]=true;
        dfs(a,b);

        if(ans>0) {
            System.out.println(ans);
        }else{
            System.out.println("TT");
        }
    }
    static void dfs(int a, int b){

        for(int i=0;i<4;i++){
            int nowx=a+dirX[i];
            int nowy=b+dirY[i];

            if(nowx>=0&&nowy>=0&&nowx<n&&nowy<m){
                if((gragh[nowx][nowy]=='P'||gragh[nowx][nowy]=='O')&&!visited[nowx][nowy]){
                    visited[nowx][nowy]=true;
                    if(gragh[nowx][nowy]=='P') {
                        ans++;
                    }
                    dfs(nowx,nowy);
                }
            }
        }
    }
}