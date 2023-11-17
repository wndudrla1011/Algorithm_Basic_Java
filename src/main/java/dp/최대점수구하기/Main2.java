package dp.최대점수구하기;

import java.io.IOException;

public class Main2 {

    public static void main(String[] args) throws IOException {
        int N = readInt(); //문제 개수
        int M = readInt(); //제한 시간
        Case[] A = new Case[N]; //각 점수 및 제한시간
        int[] dp = new int[M + 1]; //남은 제한 시간이 i였을 때 최대 점수

        for (int i = 0; i < N; i++) A[i] = new Case(readInt(), readInt());

        for (int i = 0; i < N; i++) {
            for (int j = M; j > 0; j--) { //제한 시간 (중복 계산 방지)
                if (A[i].timer <= j) dp[j] = Math.max(dp[j], A[i].point + dp[j - A[i].timer]); //점화식
            }
        }

        System.out.println(dp[M]);
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
