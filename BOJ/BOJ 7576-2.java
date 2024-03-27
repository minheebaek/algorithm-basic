import java.util.*;
/**
 * 1.BOJ 7576
 * 2.BFS
 * 3.원소들의 변경이 자주 일어나서 연결리스트를 생각했다.
 */

/**
 * 1.문제 꼼꼼하게 읽기
 * 2.BFS 큐에 쌓이는 순서는 반드시 거리 순이다
 * 3.여러개의 시작점에서 모든 지점으로의 거리문제 =>큐에 다 넣고 BFS 하기
 * 4.따로 dist 배열을 만들기보다 storage 배열을 활용하는게 더 편했다
 */
public class Main {
    static int n,m;
    static int[][] storage;
    static int[] dirX={1,0,-1,0};
    static int[] dirY={0,-1,0,1};
    static Queue<Integer>queue = new LinkedList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        m =scan.nextInt();
        n =scan.nextInt();

        storage=new int[n][m];

        for(int i=0; i<n;i++){
            for(int j=0; j<m;j++){
                storage[i][j]=scan.nextInt();
            }
        }

        for(int i=0; i<n;i++){
            for(int j=0; j<m;j++){
                if(storage[i][j]==1){ //시작점이 여러개일경우 모두 큐에 집어넣는다
                    queue.add(i);
                    queue.add(j);
                }

            }
        }
        bfs();
        int max=-1;
        for(int i=0; i<n;i++){
            for(int j=0; j<m;j++){
                if(storage[i][j]==0) {
                    System.out.println("-1");
                    return;
                }
                max=Math.max(max,storage[i][j]);
            }
        }
        System.out.println(max-1);

    }
    static void bfs(){
        while(!queue.isEmpty()){
            int curx=queue.poll();
            int cury=queue.poll();

            for(int i=0; i<4; i++){
                int nx =curx+dirX[i];
                int ny=cury+dirY[i];

                if(nx<0||ny<0||nx>=n||ny>=m){
                    continue;
                }
                if(storage[nx][ny]==0){
                    storage[nx][ny]=storage[curx][cury]+1;
                    queue.add(nx);
                    queue.add(ny);
                }
            }
        }
    }
}