package dp.최대점수구하기;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt(); //문제 개수
        int M = readInt(); //제한 시간
        Case[] A = new Case[N + 1]; //각 점수 및 제한시간
        int[][] dp = new int[N + 1][M + 1]; //i 번째 케이스까지 남은 제한 시간이 j였을 때 최대 점수

        for (int i = 1; i <= N; i++) A[i] = new Case(readInt(), readInt());

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) { //제한 시간
                if (A[i].timer > j) dp[i][j] = dp[i - 1][j]; //시간 초과
                else dp[i][j] = Math.max(dp[i - 1][j], A[i].point + dp[i - 1][j - A[i].timer]); //max(포함x, 포함o)
            }
        }

        System.out.println(dp[N][M]);
    }

    static class Case {
        int point;
        int timer;

        public Case(int point, int timer) {
            this.point = point;
            this.timer = timer;
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
