import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        int K =Integer.parseInt(br.readLine());

        System.out.println(solution(A,T,K));
    }
    static int solution(int A, int T, int K) {
        int N = 2;
        int bbun = 0;
        int degi = 0;

        while (true) {
            for (int i = 0; i < 4; i++) { //고정 뻔-데기-뻔-데기
                if (i % 2 == 0) {
                    bbun++;
                } else{
                    degi++;

                }
                if (bbun == T && K == 0) {
                    return (bbun + degi - 1) % A;
                }
                if (degi == T && K == 1) {
                    return (bbun + degi - 1) % A;
                }
            }
            for (int i = 0; i < N; i++) {
                bbun++;
                if (bbun == T && K == 0) {
                    return (bbun + degi - 1) % A;
                }
            }
            for (int i = 0; i < N; i++) {
                degi++;
                if (degi == T && K == 1) {
                    return (bbun + degi - 1) % A;
                }
            }
            N++;
        }
    }
}