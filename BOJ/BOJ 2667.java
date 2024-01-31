import java.util.*;
import java.io.*;

public class Main{
    static int[] dirX = {0,0,-1,1};
    static int[] dirY = {-1,1,0,0};
    static int[][] map;
    static int[][] visited;
    static int N;
    static int housesize;
    static ArrayList<Integer> arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new int[N][N];
        arr = new ArrayList<>();

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }
        int housecount = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visited[i][j]==0 && map[i][j]==1){
                    visited[i][j]=1;
                    dfs(i,j);
                    arr.add(housesize);
                    housesize=0;
                    housecount++;
                }
            }
        }
        System.out.println(housecount);
        Collections.sort(arr);
        for(int housesize : arr){
            System.out.println(housesize);
        }
    }

    public static void dfs(int x, int y){
        housesize++;
        for(int i=0; i<4; i++){
            int nowx = x+dirX[i];
            int nowy = y+dirY[i];

            if(nowx>=0 && nowy>=0 && nowx<N && nowy<N){
                if(visited[nowx][nowy]==0 && map[nowx][nowy]==1 ){
                    visited[nowx][nowy]=visited[x][y]+1;
                    dfs(nowx,nowy);
                }
            }
        }
    }
}