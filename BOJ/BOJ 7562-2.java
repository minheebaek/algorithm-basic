import java.util.*;
import java.io.*;
/** 4주차
 * 1.BOJ 7562
 * 2.BFS
 * 3.4방향 탐색하며 두 지점 거리 구하는 문제 BFS
 * 4.bfs O(NM)
 */

/**
 * 미로탐색과 같은 문제, 마지막 지점 확인할 때는 큐에서 꺼낸 curx,cury를 확인한다.
 */
public class Main {
    static int n, startx,starty,endx,endy;
    static int[][] chess;
    static boolean[][] visited;
    static int[] dirx={1,2,2,1,-1,-2,-2,-1};
    static int[] diry={2,1,-1,-2,-2,-1,1,2};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            chess = new int[n][n];
            visited = new boolean[n][n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            startx = Integer.parseInt(st.nextToken());
            starty = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            endx = Integer.parseInt(st.nextToken());
            endy = Integer.parseInt(st.nextToken());

            bfs(startx, starty);
        }
    }
    static void bfs(int x,int y){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);
        visited[x][y]=true;

        while(!queue.isEmpty()){
            int curx= queue.poll();
            int cury= queue.poll();

            if(curx==endx&&cury==endy){
                System.out.println(chess[curx][cury]);
                return;
            }

            for(int i=0; i<8; i++){
                int nx=curx+dirx[i];
                int ny=cury+diry[i];

                if(nx<0||ny<0||nx>=n||ny>=n) continue;

                if(!visited[nx][ny]){
                    visited[nx][ny]=true;
                    chess[nx][ny]=chess[curx][cury]+1;
                    queue.add(nx);
                    queue.add(ny);
                }
            }
        }
    }
}