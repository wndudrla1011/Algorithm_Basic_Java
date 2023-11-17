package dp.계단오르기;

import java.io.IOException;

public class Main {

    static int[] dp = {1, 2};
    static int N, ans;

    public static void main(String[] args) throws IOException {
        N = readInt();
        DP(0);
        System.out.println(ans);
    }

    static void DP(int v) {
        if (v > N) return;
        if (v == N) ans++;
        else {
            for (int i = 0; i < 2; i++) DP(v + dp[i]);
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
