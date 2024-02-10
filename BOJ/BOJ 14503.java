import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] room;
    static int count;
    static int[] dirX={-1,0,1,0}; //북동남서
    static int[] dirY={0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N =Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        room=new int[N][M];

        st= new StringTokenizer(br.readLine());
        int r =Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());
        int d=Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                room[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        count=1;
        dfs(r,c,d);
        System.out.println(count);
    }
    static void dfs(int r, int c, int d){
        room[r][c]=-1; //청소 완료

        for(int i=0; i<4; i++){
            d=(d+3)%4;
            int nowx=r+dirX[d];
            int nowy=c+dirY[d];
            //만약 청소되지 않은 칸이 없어서 i++ 되어 다른 칸을 찾더라도 d는 이미 바뀌었기 때문에
            //방향은 이미 90도 돌려짐
            if(nowx>=0&&nowy>=0&&nowx<N&&nowy<M){ //청소되지 않은 칸 찾으면 dfs 호출
                if(room[nowx][nowy]==0){
                    room[nowx][nowy]=-1;
                    count++;
                    dfs(nowx,nowy,d);
                    return; //여기서 return 안하면 dfs 종료되면서 for문 실행할게 남아있으면
                    //실행되면서 다른 곳으로 청소하러 갈 수 있음
                }
            }
        }
        //인접한 4칸 모두 청소 완료시 for문 밖으로 나옴
        //후진 여부, 체크 d 방향은 유지하되 로봇방향은 뒤로 감
        int back=(d+2)%4;
        int bx=r+dirX[back];
        int by=c+dirY[back];

        if(bx>=0&&by>=0&&bx<N&&by<M){
            if(room[bx][by]==-1){
                dfs(bx,by,d);
            }
        }
    }
}
