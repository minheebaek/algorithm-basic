import java.util.*;

public class Main {
    static ArrayList<Integer>[] gragh;
    static boolean[] visited;
    static int[] depth;
    static int sum;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();

        gragh =new ArrayList[N+1];

        for(int i=0; i<=N; i++){
            gragh[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            int A = scan.nextInt();
            int B = scan.nextInt();
            gragh[A].add(B);
            gragh[B].add(A);
        }
        int min =Integer.MAX_VALUE;
        int ans = -1;
        for(int i=1; i<=N; i++){
            depth = new int[N+1];
            visited = new boolean[N+1];
            bfs(i);

            if(min>sum) {
                min = sum; //케빈 베이컨 수 비교
                ans = i;
            }
            sum=0;
        }
        System.out.println(ans);
    }
    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next:gragh[cur]){//인접 노드들 방문
                if(!visited[next]){
                    visited[next]=true;
                    depth[next]=depth[cur]+1;
                    queue.add(next);
                }
            }
        }
        for(int i=1; i<depth.length; i++){ //depth.length = N+1
            sum += depth[i];
        }
    }
}