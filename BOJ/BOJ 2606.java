import java.util.*;
import java.io.*;

public class Main{
    public static ArrayList<Integer>[] list;
    public static boolean[] visited;
    public static int ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //정점
        int m = Integer.parseInt(br.readLine()); //간선

        list = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=0; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        bfs();
        System.out.println(ans);

    }
    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        visited[1] = true;
        queue.add(1);

        while(!queue.isEmpty()){
            int v =queue.poll();
            for(int next :list[v]){
                if(!visited[next]){
                    queue.add(next);
                    visited[next]=true;
                    ans++;
                }
            }
        }
    }
}