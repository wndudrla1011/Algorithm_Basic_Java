package DFS_BFS.조합구하기;

import java.io.IOException;

public class Main2 {

    static int[] ch, C;
    static int N, M;

    public static void main(String[] args) throws IOException {
        N = readInt(); //N개 중
        M = readInt(); //M개 선택
        C = new int[M];
        ch = new int[N + 1];

        DFS(0, 1);
    }

    static void DFS(int L, int start) {
        if (L == M) {
            for (int v : C) System.out.print(v + " ");
            System.out.println();
        }
        else {
            for (int i = start; i <= N; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    C[L] = i;
                    DFS(L + 1, i + 1);
                    ch[i] = 0;
                }
            }
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
