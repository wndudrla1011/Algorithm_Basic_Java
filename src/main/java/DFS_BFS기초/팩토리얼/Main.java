package DFS_BFS기초.팩토리얼;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        System.out.println(DFS(N));
    }

    static int DFS(int n) {
        if (n == 1) return 1;
        return n * DFS(n - 1);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
