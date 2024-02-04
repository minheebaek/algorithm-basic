import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] S = new int[N+1];
        int[] D = new int[N+1];
        int[] temp;

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            S[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            D[i] = Integer.parseInt(st.nextToken());
        }

        for(int j=0; j<K; j++){
            temp = new int[N+1];

            for (int i = 1; i <= N; i++) {
                temp[D[i]] = S[i];
            }
            S = temp;
        }

        for(int i=1; i<=N; i++) {
            sb.append(S[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}