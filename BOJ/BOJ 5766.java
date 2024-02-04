import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if(N == 0 & M == 0){
                break;
            }
            int[] arr = new int[10001];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    if (arr[num]==0) {
                        arr[num] = 1;
                    } else {
                        arr[num]++;
                    }

                }
            }

            int firstNum = -1;
            for (int i = 0; i < 10001; i++) {
                firstNum=Math.max(firstNum,arr[i]);
            }

            int secondMax = -1;
            for (int i = 0; i < 10001; i++) {
                if(arr[i]!=firstNum){
                    secondMax = Math.max(secondMax,arr[i]);
                }
            }
            for (int i = 0; i < 10001; i++) {
                if (arr[i] == secondMax) {
                    sb.append(i).append(" ");
                }
            }

            System.out.println(sb.toString());
        }
    }
}