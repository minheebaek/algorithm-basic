import java.util.*;
import java.io.*;

public class Main{
    static int N, M;
    static int[] dirX = {0,0,-1,1};
    static int[] dirY = {-1,1,0,0};
    static int[][] storage;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        storage = new int[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                storage[i][j] = Integer.parseInt(st2.nextToken());
                if (storage[i][j] == 1) {
                    queue.add(i);
                    queue.add(j);
                }
            }
        }
        System.out.println(bfs());
    }

    public static int bfs(){
        while(!queue.isEmpty()){
            int nowX = queue.poll();
            int nowY = queue.poll();
            visited[nowX][nowY] = true;

            for(int i=0; i<4; i++){
                int nextX =nowX + dirX[i];
                int nextY = nowY +dirY[i];
                if(nextX>=0 && nextY>=0 && nextX<N && nextY<M){
                    if(storage[nextX][nextY]==0){
                        queue.add(nextX);
                        queue.add(nextY);
                        storage[nextX][nextY] = 1;
                    }
                }
            }

        }
        int max = -1;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(storage[i][j] == 0){
                    max = -1;
                    return max;
                }
                if(storage[i][j]>max) max=storage[i][j];
            }
        }
        return max;

    }
}