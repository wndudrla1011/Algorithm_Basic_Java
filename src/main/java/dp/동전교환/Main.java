package dp.동전교환;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt(); //동전 종류 개수
        int[] coins = new int[N]; //동전 종류

        for (int i = 0; i < N; i++) coins[i] = readInt();

        int M = readInt(); //만들어야 하는 금액
        int[] dp = new int[M + 1]; //i 금액을 만드는 데 드는 최소 동전 개수

        for (int i = 1; i <= M; i++) dp[i] = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = coins[i]; j <= M; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1); //coins[i] 사용
            }
        }

        System.out.println(dp[M]);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
