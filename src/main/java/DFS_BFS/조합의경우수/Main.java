package DFS_BFS.조합의경우수;

import java.io.IOException;

public class Main {

    static int n, r;
    static int[][] A; //체크 배열

    public static void main(String[] args) throws IOException {
        n = readInt();
        r = readInt();
        A = new int[n + 1][r + 1];

        System.out.println(DFS(n, r));
    }

    static int DFS(int a, int b) {
        if (A[a][b] > 0) return A[a][b];
        if (b == 0 || a == b) return 1;
        else {
            return A[a][b] = DFS(a - 1, b - 1) + DFS(a - 1, b);
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
