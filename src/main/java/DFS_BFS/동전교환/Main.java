package DFS_BFS.동전교환;

import java.io.IOException;

public class Main {

    static int N, M, ans;
    static int[] coins;

    public static void main(String[] args) throws IOException {
        N = readInt(); //동전 종류 개수
        coins = new int[N];

        for (int i = 0; i < N; i++) {
            coins[i] = readInt();
        }

        M = readInt(); //거슬러 줄 금액

        DFS(0, 0);
        System.out.println(ans);
    }

    static void DFS(int cnt, int sum) {
        if (ans > 0 && cnt > ans) return;
        if (sum >= M) {
            if (sum == M) ans = cnt;
        }
        else {
            for (int i = N - 1; i >= 0; i--) { //큰 동전부터 (가지치기를 많이 하기 위해서)
                DFS(cnt + 1, sum + coins[i]);
            }
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
