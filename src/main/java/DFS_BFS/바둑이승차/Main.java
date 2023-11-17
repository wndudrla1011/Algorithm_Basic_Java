package DFS_BFS.바둑이승차;

import java.io.IOException;

public class Main {

    static int[] A;
    static int C, N, max;

    public static void main(String[] args) throws IOException {
        C = readInt(); //최대 무게
        N = readInt(); //마릿 수
        A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = readInt();
        }

        DFS(0, 0);
        System.out.println(max);
    }

    static void DFS(int L, int sum) {
        if (C < sum) return;
        if (L == N) max = Math.max(max, sum);
        else {
            DFS(L + 1, sum + A[L]);
            DFS(L + 1, sum);
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
