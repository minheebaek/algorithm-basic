import java.util.*;
import java.io.*;
//M 가로 행 x
//N 세로 열 y
//H 높이
class tomato{
    int x;
    int y;
    int z;

    tomato(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
public class Main {
    static int N, M, H;
    static int[] dirX = {0, 0, -1, 1, 0, 0};
    static int[] dirY = {-1, 1, 0, 0, 0, 0};
    static int[] dirZ = {0, 0, 0, 0, -1, 1};
    static int[][][] storage;
    static Queue<tomato> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        storage = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                StringTokenizer str2 = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    storage[i][j][k] = Integer.parseInt(str2.nextToken());
                    if (storage[i][j][k] == 1) {
                        queue.add(new tomato(j, k, i)); //토마토 객체 만들어서 넣기
                    }
                }
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        while (!queue.isEmpty()) {
            tomato t = queue.poll(); //큐에 있는 토마토 객체 꺼내서 t 변수와 연결
            int x = t.x;
            int y = t.y;
            int z = t.z;

            for (int i = 0; i < 6; i++) {
                int nowx = x + dirX[i];
                int nowy = y + dirY[i];
                int nowz = z + dirZ[i];

                if (nowx >= 0 && nowy >= 0 && nowz >= 0 && nowx < N && nowy < M && nowz < H) {
                    if (storage[nowz][nowx][nowy] == 0) {
                        queue.add(new tomato(nowx, nowy, nowz));
                        storage[nowz][nowx][nowy] = storage[z][x][y] + 1;
                    }
                }
            }
        }
        int max = -1;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (storage[i][j][k] == 0) {
                        max = -1;
                        return max;
                    }
                    if (storage[i][j][k] > max) {
                        max = storage[i][j][k];
                    }
                }
            }
        }
        return max - 1;

    }
}