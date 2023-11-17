package DFS_BFS.합이같은부분집합;

import java.io.IOException;

public class Main2 {

    static int[] A;
    static int N, total;
    static String ans = "NO";

    public static void main(String[] args) throws IOException {
        N = readInt();
        A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = readInt();
            total += A[i];
        }

        DFS(0, 0);
        System.out.println(ans);
    }

    static void DFS(int L, int sum) {
        if (ans.equals("YES")) return;
        if (total / 2 < sum) return;
        if (L == N) {
            if (total - sum == sum) ans = "YES";
        } else {
            DFS(L + 1, sum + A[L]);
            DFS(L + 1, sum);
        }
    }

    static int readInt() throws IOException {
        int n = 0;
        boolean isNegative = false;
        while (true) {
            int input = System.in.read();
            if (input <= 32) {
                return isNegative ? n * -1 : n;
            } else if (input == '-')
                isNegative = true;
            else
                n = (n << 3) + (n << 1) + (input & 15);
        }
    }

}
