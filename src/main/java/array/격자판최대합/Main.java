package array.격자판최대합;

import java.io.IOException;

public class Main {

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int[][] map = new int[N][N];
        int sum;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = readInt();
            }
        }

        //행의 합
        for (int i = 0; i < N; i++) {
            sum = 0;
            for (int j = 0; j < N; j++) {
                sum += map[i][j];
            }
            check_max(max, sum);
        }

        //열의 합
        for (int i = 0; i < N; i++) {
            sum = 0;
            for (int j = 0; j < N; j++) {
                sum += map[j][i];
            }
            check_max(max, sum);
        }

        //대각선의 합1
        sum = 0;
        for (int i = 0; i < N; i++) {
            sum += map[i][i];
        }

        check_max(max, sum);

        //대각선의 합2
        sum = 0;
        for (int i = 0; i < N; i++) {
            sum += map[i][N - i - 1];
        }

        check_max(max, sum);

        System.out.println(max);
    }

    private static void check_max(int cur_max, int sum) {
        if (cur_max < sum) max = sum;
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        if (n == 10) n = 0;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}