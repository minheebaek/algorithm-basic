import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        tree=new ArrayList[N+1];
        visited=new boolean[N+1];
        parent=new int[N+1];

        for(int i=0; i<=N; i++){
            tree[i]=new ArrayList<>();
        }

        for(int i=1; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            tree[A].add(B);
            tree[B].add(A);
        }

        dfs(1);

        for(int i=2; i<=N; i++ ){
            System.out.println(parent[i]);
        }
    }
    static void dfs(int node){
        visited[node]=true;

        for(int next:tree[node]){
            if(!visited[next]){
                parent[next]=node;
                dfs(next);
            }
        }
    }
}
