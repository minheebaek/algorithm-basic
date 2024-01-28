import java.util.*;
import java.io.*;

public class Main{
    public static ArrayList<Integer>[] gragh;
    public static boolean[] visited1;
    public static boolean[] visited2;
    public static StringBuilder sb = new StringBuilder();
    public static StringBuilder sb2 = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        gragh = new ArrayList[n+1];
        visited1 = new boolean[n+1];
        visited2 = new boolean[n+1];

        for(int i=0; i<=n; i++){
            gragh[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());

            gragh[x].add(y);
            gragh[y].add(x);
        }

        for(int i=0; i<=n; i++){
            Collections.sort(gragh[i]);
        }

        dfs(v);
        System.out.println(sb.toString());
        bfs(v);

    }
    public static void dfs(int v){
        visited1[v] = true;
        sb.append(v).append(" ");
        for(int next:gragh[v]){
            if(!visited1[next]){
                dfs(next);
            }
        }
    }

    public static void bfs(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited2[v] = true;
        sb2.append(v).append(" ");

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next:gragh[cur]){
                if(!visited2[next]){
                    queue.add(next);
                    visited2[next] = true;
                    sb2.append(next).append(" ");
                }
            }
        }
        System.out.println(sb2.toString());
    }
}