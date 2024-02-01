import java.util.*;
import java.io.*;

public class Main{
    static int[][] land;
    static boolean[][] visited;
    static int M, N;
    static int[] dirX = {0,0,-1,1};
    static int[] dirY = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test = 0; test < T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            land = new int[M][N];
            visited = new boolean[M][N];

            for (int i = 0; i < K; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int col = Integer.parseInt(st2.nextToken());
                int row = Integer.parseInt(st2.nextToken());
                land[col][row] = 1;
            }

            int bugcount = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (land[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        bugcount++;
                    }
                }
            }
            System.out.println(bugcount);

        }
    }

    public static void bfs(int i, int j){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        queue.add(j);
        visited[i][j]=true;

        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();
            for(int l=0; l<4; l++){
                int nowx = x + dirX[l];
                int nowy = y + dirY[l];

                if(nowx>=0 && nowy>=0 && nowx<M && nowy<N){
                    if(land[nowx][nowy]==1 && !visited[nowx][nowy]){
                        queue.add(nowx);
                        queue.add(nowy);
                        visited[nowx][nowy] = true;
                    }
                }
            }

        }
    }
}