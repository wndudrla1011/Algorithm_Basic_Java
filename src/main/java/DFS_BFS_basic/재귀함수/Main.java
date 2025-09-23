package DFS_BFS_basic.재귀함수;

import java.io.IOException;

public class Main {

    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = readInt();
        DFS(N);
        System.out.println(ans.reverse());
    }

    private static void DFS(int n) {
        if (n < 1) return;
        ans.append(" ").append(n);
        DFS(n - 1);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
