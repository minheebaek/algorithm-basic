import java.util.*;
import java.io.*;

public class Main{
    static int[] gragh;
    static boolean[] visited;
    static int N, K;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        gragh = new int[100001];
        visited = new boolean[100001];

        bfs(N);
    }
    public static void bfs(int N){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] =true;
        while(!queue.isEmpty()){
            int x= queue.poll();
            if (x == K) {
                System.out.println(gragh[x]);
                return;
            }
            for(int i=0; i<3; i++){
                int nowN=0;
                if(i==0){
                    nowN = x+1;
                }
                if(i==1){
                    nowN = x-1;
                }
                if(i==2){
                    nowN = 2*x;
                }
                if(nowN>=0 && nowN<=100000) {
                    if (!visited[nowN]) {
                        queue.add(nowN);
                        visited[nowN] = true;
                        gragh[nowN] = gragh[x] + 1;
                    }
                }
            }
        }
    }
}