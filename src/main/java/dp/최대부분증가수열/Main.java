package dp.최대부분증가수열;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int[] A = new int[N];
        int[] dp = new int[N]; //A[i]를 마지막 수로 하는 최대 부분 증가수열
        int ans = 1;

        for (int i = 0; i < N; i++) A[i] = readInt();

        dp[0] = 1;
        int max;
        for (int i = 1; i < N; i++) {
            max = 1; //자신보다 작은 수 중 가장 긴 증가수열
            for (int j = i - 1; j >= 0; j--) {
                if (A[i] > A[j]) max = Math.max(max, dp[j] + 1);
            }
            dp[i] = max;
        }

        for (int d : dp) ans = Math.max(ans, d);

        System.out.println(ans);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
