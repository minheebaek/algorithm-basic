import java.util.*;

public class Main {
    static int[][] bingoboard;
    static int bingo = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        bingoboard = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                bingoboard[i][j] = scan.nextInt();
            }
        }

        for (int i = 1; i <= 25; i++) {
            int ans = scan.nextInt();

            for (int m = 0; m < 5; m++) {
                for (int n = 0; n < 5; n++) {
                    if (bingoboard[m][n] == ans) {
                        bingoboard[m][n] = -1;
                    }
                }
            }

            rowCheck();
            colCheck();
            leftDiagonal();
            rightDiagonal();

            if (bingo >= 3) {
                System.out.println(i);
                break;
            }
            bingo=0;
        }
    }

    public static void rowCheck() { //가로
        for (int i = 0; i < 5; i++) {
            int colCount = 0;
            for (int j = 0; j < 5; j++) {
                if (bingoboard[i][j] == -1) {
                    colCount++;
                }
            }
            if (colCount == 5) {
                bingo++;
            }
        }
    }

    public static void colCheck() { //세로
        for (int i = 0; i < 5; i++) {
            int rowCount = 0;
            for (int j = 0; j < 5; j++) {
                if (bingoboard[j][i] == -1) {
                    rowCount++;
                }
            }
            if (rowCount == 5) {
                bingo++;
            }
        }
    }

    public static void leftDiagonal() {
        int leftDiagonalCount = 0;
        for (int i = 0; i < 5; i++) {
            if (bingoboard[i][i] == -1) {
                leftDiagonalCount++;
            }

        }
        if (leftDiagonalCount == 5) {
            bingo++;
        }
    }

    public static void rightDiagonal() {
        int rightDiagonalCount = 0;
        for (int i = 0; i < 5; i++) {
            if (bingoboard[i][4 - i] == -1) {
                rightDiagonalCount++;
            }
        }
        if (rightDiagonalCount == 5) {
            bingo++;
        }

    }
}