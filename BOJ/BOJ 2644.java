import java.util.*;
import java.io.*;

public class Main {
    public static ArrayList<Integer>[] gragh;
    public static boolean[] visited;
    public static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        gragh = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        dist = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            gragh[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());

            gragh[x].add(y);
            gragh[y].add(x);
        }

        System.out.println(bfs(start, end));
    }

    public static int bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        dist[start] = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : gragh[cur]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    dist[next] = dist[cur] + 1;
                    if (next == end) return dist[next];
                }
            }
        }
        return -1;
    }
}