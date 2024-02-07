import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Character[][] dnaArr = new Character[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                dnaArr[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < M; i++) {
            int[] arr = new int[4]; //ACGT
            for (int j = 0; j < N; j++) {
                if (dnaArr[j][i] == 'A')
                    arr[0]++;
                if (dnaArr[j][i] == 'C')
                    arr[1]++;
                if (dnaArr[j][i] == 'G')
                    arr[2]++;
                if (dnaArr[j][i] == 'T')
                    arr[3]++;
            }

            int max = -1;
            int index = -1;
            for (int j = 0; j < arr.length; j++) {
                if(max<arr[j]){
                    max=arr[j];
                    index = j;
                }
            }

            if (index == 0)
                sb.append("A");
            if (index == 1)
                sb.append("C");
            if (index == 2)
                sb.append("G");
            if (index == 3)
                sb.append("T");
        }

        int hd = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dnaArr[i][j] != sb.charAt(j)) {
                    hd++;
                }
            }
        }
        System.out.println(sb.toString());
        System.out.println(hd);

    }
}