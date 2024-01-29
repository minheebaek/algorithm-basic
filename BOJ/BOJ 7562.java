import java.util.*;
import java.io.*;

public class Main{
    static int[] dirX = {-1,1,-1,1,2,2,-2,-2};
    static int[] dirY = {2,2,-2,-2,1,-1,1,-1};
    static int I;
    static int nowX,nowY;
    static int targetX, targetY;
    static int[][] chess;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            I = Integer.parseInt(br.readLine());
            chess = new int[I][I];
            visited = new boolean[I][I];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int curX = Integer.parseInt(st.nextToken());
            int curY = Integer.parseInt(st.nextToken());

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            targetX = Integer.parseInt(st2.nextToken());
            targetY = Integer.parseInt(st2.nextToken());

            bfs(curX, curY);
            System.out.println(chess[targetX][targetY]);
        }
    }

    public static void bfs(int curX, int curY){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(curX);
        queue.add(curY);
        visited[curX][curY] = true;

        while(!queue.isEmpty()){
            nowX = queue.poll();
            nowY = queue.poll();

            for(int i=0; i<8; i++) {
                int nextX = nowX + dirX[i];
                int nextY = nowY + dirY[i];
                if (nextX >= 0 && nextY >= 0 && nextX < I && nextY < I) {
                    if (visited[targetX][targetY] == false && visited[nextX][nextY] == false) {
                        queue.add(nextX);
                        queue.add(nextY);
                        visited[nextX][nextY] =true;
                        chess[nextX][nextY] = chess[nowX][nowY] + 1;
                    }
                }
            }
        }
    }
}