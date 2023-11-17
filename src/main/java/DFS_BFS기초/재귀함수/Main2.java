package DFS_BFS기초.재귀함수;

import java.io.IOException;

public class Main2 {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        DFS(N);
    }

    private static void DFS(int n) {
        if (n < 1) return;
        DFS(n - 1);
        System.out.print(n + " ");
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
