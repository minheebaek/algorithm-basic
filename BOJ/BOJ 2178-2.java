import java.util.*;
import java.io.*;
/**
 * 1.BOJ 2178
 * 2.bfs
 * 3.최단거리, 양방향 탐색 => bfs
 * 4.O(nm)
 */

/** 느낀점
 * 1.바킹독 보고 효율적인 변수나 조건 설정 방법을 배웠다
 * 2.따로 종료 조건을 설정하지 않아도 bfs는 최단거리로 접근하니까 maze[n-1][m-1]이 값만 알게 되면 정답이 된다는 사실을 배웠다.
 */
public class Main {
    static int n, m;
    static int[][] maze;
    static boolean[][] visited;
    static int[] dirX = {1, 0, -1, 0};
    static int[] dirY = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(0, 0);

        System.out.println(maze[n-1][m-1]); //따로 종료 조건을 설정하지 않아도 bfs는 최단거리로 접근하니까
        //maze[n-1][m-1]이 값만 알게 되면 정답이 됨
    }

    static void bfs(int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);
        visited[0][0] = true;

        while (!queue.isEmpty()) {

            int curx = queue.poll();
            int cury = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curx + dirX[i];
                int ny = cury + dirY[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (maze[nx][ny] != 1 || visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                maze[nx][ny]=maze[curx][cury]+1;
                queue.add(nx);
                queue.add(ny);
            }
        }
    }
}