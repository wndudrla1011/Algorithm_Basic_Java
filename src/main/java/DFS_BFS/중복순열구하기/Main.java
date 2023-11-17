package DFS_BFS.중복순열구하기;

import java.io.IOException;

public class Main {

    static int N, M;
    static int[] A;

    public static void main(String[] args) throws IOException {
        N = readInt(); //숫자 범위
        M = readInt(); //뽑은 횟수
        A = new int[M];

        DFS(0);
    }

    static void DFS(int L) {
        if (L == M) {
            for (int n : A) System.out.print(n + " ");
            System.out.println();
            return;
        }
        for (int i = 1; i <= N; i++) {
            A[L] = i;
            DFS(L + 1);
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
