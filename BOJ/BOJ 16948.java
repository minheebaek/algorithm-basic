import java.util.*;
public class Main{
    static int n;
    static int startx,starty;
    static int endx, endy;
    static int count;
    static int[] dirX={-2,-2,0,0,2,2};
    static int[] dirY={-1,1,-2,2,-1,1};
    static int[][] chess;
    static boolean[][] visited;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n=scan.nextInt();
        startx=scan.nextInt();
        starty=scan.nextInt();
        endx=scan.nextInt();
        endy=scan.nextInt();

        chess=new int[n][n];
        visited=new boolean[n][n];

        count=0;

        bfs();

    }
    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startx);
        queue.add(starty);
        visited[startx][starty]=true;
        while(!queue.isEmpty()){

            int x=queue.poll();
            int y=queue.poll();

            for(int i=0;i<6;i++){
                int nowx=x+dirX[i];
                int nowy=y+dirY[i];

                if(nowx>=0&&nowy>=0&&nowx<n&&nowy<n){
                    if(!visited[nowx][nowy]){
                        visited[nowx][nowy]=true;
                        chess[nowx][nowy]=chess[x][y]+1;
                        queue.add(nowx);
                        queue.add(nowy);

                        if(nowx==endx&&nowy==endy){
                            System.out.println(chess[nowx][nowy]);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("-1");
    }
}