import java.util.*;
import java.io.*;

public class Main{
    static int[] dirX = {0,0,-1,1};
    static int[] dirY = {-1,1,0,0};
    static int[][] area;
    static boolean[][] visited;
    static ArrayList<Integer> list;
    static int N, nowx, nowy;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        area = new int[N][N];
        list = new ArrayList<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                area[i][j] = Integer.parseInt(st.nextToken());
                if(!list.contains(area[i][j])){
                    list.add(area[i][j]);
                }
            }
        }

        int max = -1;
        for(int height : list){
            visited = new boolean[N][N];
            int safeArea = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j] && area[i][j]>=height){
                        dfs(i,j,height);
                        safeArea++;
                    }
                }
            }
            max=Math.max(max, safeArea);
        }
        System.out.println(max);
    }
    public static void dfs(int x, int y, int height){
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            nowx = x+dirX[i];
            nowy = y+dirY[i];

            if(nowx>=0 && nowy>=0 && nowx<N && nowy<N){
                if(!visited[nowx][nowy] && area[nowx][nowy]>=height){
                    dfs(nowx,nowy,height);
                }
            }
        }
    }
}