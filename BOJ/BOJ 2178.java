import java.util.*;
import java.io.*;

public class Main{
    static int[] dirX = {0,0,-1,1};
    static int[] dirY = {-1,1,0,0};
    static int[][] maze;
    static boolean[][] visited;
    static int N,M;
    static int nowX,nowY;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                maze[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(0,0);
        System.out.println(maze[N-1][M-1]);
    }
    public static void bfs(int x, int y){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);
        visited[x][y] = true;

        while(!queue.isEmpty()){
            nowX=queue.poll();
            nowY=queue.poll();

            for(int i=0; i<4; i++){
                int nextX = nowX+dirX[i];
                int nextY = nowY+dirY[i];

                if(nextX>=0 && nextY>=0 && nextX<N && nextY<M){
                    if(maze[nextX][nextY]==1 && visited[nextX][nextY]==false){
                        queue.add(nextX);
                        queue.add(nextY);
                        visited[nextX][nextY]=true;
                        maze[nextX][nextY]=maze[nowX][nowY]+1;
                    }
                }
            }
        }
    }
}