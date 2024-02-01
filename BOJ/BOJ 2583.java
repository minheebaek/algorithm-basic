import java.util.*;
import java.io.*;

public class Main{
    static int[] dirX = {0,0,-1,1};
    static int[] dirY = {-1,1,0,0};
    static int[][] paper;
    static ArrayList<Integer> arr = new ArrayList<>();
    static int size;
    static int N,M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        paper = new int[M][N];

        for(int i=0; i<K; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            int leftx = Integer.parseInt(st2.nextToken());
            int lefty = Integer.parseInt(st2.nextToken());
            int rightx = Integer.parseInt(st2.nextToken());
            int righty = Integer.parseInt(st2.nextToken());

            for(int l=lefty; l<righty; l++){
                for(int m=leftx; m<rightx; m++){
                    paper[l][m]=1;
                }

            }

        }
        int count=0;
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(paper[i][j]==0){
                    paper[i][j]=1;
                    dfs(i,j);
                    count++;
                    arr.add(size);
                    size=0;
                }
            }
        }
        System.out.println(count);
        Collections.sort(arr);

        for(int asize : arr){
            sb.append(asize).append(" ");
        }

        System.out.println(sb.toString());
    }
    public static void dfs(int x, int y){
        size++;
        for(int i=0; i<4; i++){
            int nowx =x+dirX[i];
            int nowy = y+dirY[i];

            if(nowx>=0&&nowy>=0&&nowx<M&nowy<N){
                if(paper[nowx][nowy]==0){
                    paper[nowx][nowy]=1;
                    dfs(nowx,nowy);

                }
            }

        }
    }
}