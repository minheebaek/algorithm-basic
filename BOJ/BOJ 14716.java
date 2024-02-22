import java.util.*;
import java.io.*;
public class Main{
    static int n,m;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dirX={0,0,-1,1,-1,1,1,-1};
    static int[] dirY={1,-1,0,0,-1,1,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n =Integer.parseInt(st.nextToken());
        m =Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited =new boolean[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==1&&!visited[i][j]){
                    visited[i][j]=true;
                    dfs(i,j);
                    count++;
                }
            }
        }
        System.out.println(count);


    }
    static void dfs(int x,int y){
        for(int i=0;i<8;i++){
            int nowx=x+dirX[i];
            int nowy=y+dirY[i];

            if(nowx>=0&&nowy>=0&&nowx<n&&nowy<m){
                if(arr[nowx][nowy]==1&&!visited[nowx][nowy]){
                    visited[nowx][nowy]=true;
                    dfs(nowx,nowy);
                }
            }
        }
    }
}