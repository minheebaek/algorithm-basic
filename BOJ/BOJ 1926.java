import java.util.*;
import java.io.*;

public class Main{
    static int[] dirX = {0,0,-1,1};
    static int[] dirY = {-1,1,0,0};
    static int[][] paper;
    static int[][] visited;
    static int n,m;
    static int nowx, nowy;
    static int artsize;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        paper = new int[n][m];
        visited = new int[n][m];

        for(int i=0; i<n; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                paper[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        int max = 0;
        int artcount = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(paper[i][j]==1 && visited[i][j]==0){
                    visited[i][j] = 1;
                    dfs(i,j);
                    artcount++;
                    max = Math.max(max,artsize);
                    artsize=0;
                }
            }
        }
        System.out.println(artcount);
        System.out.println(max);

    }
    public static void dfs(int x, int y){
        artsize++;
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                nowx = x+dirX[i];
                nowy = y+dirY[i];

                if(nowx>=0 && nowy>=0 && nowx<n && nowy<m){
                    if(visited[nowx][nowy]==0 && paper[nowx][nowy]==1){
                        visited[nowx][nowy] = visited[x][y]+1;
                        dfs(nowx,nowy);
                    }
                }
            }
        }
    }
}