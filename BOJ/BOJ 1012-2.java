import java.util.*;
import java.io.*;

/**
 * 1.BOJ 1012
 * 2.bfs
 * 3.양방향 탐색, bfs/dfs 상관x
 * 4.O(NM)
 */

/**
 * 1.왜 틀렸지 고민하기보다 왜 이 코드가 맞는지, 효율적인지 고민하는게 더 빠르다
 */

public class Main {
    static int n,m;
    static int[][] area;
    static boolean[][] visited;
    static int[] dirX={1,0,-1,0};
    static int[] dirY={0,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int w = 0; w < t; w++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            area = new int[n][m];
            visited = new boolean[n][m];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                area[x][y] = 1;

            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (visited[i][j] || area[i][j] == 0) {
                        continue;
                    }
                    bfs(i, j);
                    count++;
                }
            }
            System.out.println(count);
        }

    }
    static void bfs(int x, int y){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);

        while(!queue.isEmpty()){
            int curx=queue.poll();
            int cury=queue.poll();

            for(int i=0; i<4; i++){
                int nx=curx+dirX[i];
                int ny=cury+dirY[i];

                if(nx<0||ny<0||nx>=n||ny>=m){
                    continue;
                }
                if(visited[nx][ny]||area[nx][ny]==0){
                    continue;
                }
                visited[nx][ny]=true;
                queue.add(nx);
                queue.add(ny);
            }
        }
    }
}