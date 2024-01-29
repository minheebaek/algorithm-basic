import java.util.*;
import java.io.*;

public class Main{
    public static ArrayList<Integer>[] gragh;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        gragh = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=0; i<=n; i++){
            gragh[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st2.nextToken());
            int v = Integer.parseInt(st2.nextToken());

            gragh[u].add(v);
            gragh[v].add(u);
        }
        int count =0;
        for(int i=1; i<=n; i++){
            if(visited[i]) continue;
            dfs(i);
            count++;
        }
        System.out.println(count);

    }
    public static void dfs(int start){
        visited[start] = true;
        for(int next : gragh[start]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}