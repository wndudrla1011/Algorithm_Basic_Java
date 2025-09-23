package DFS_BFS_basic.이진수출력;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        DFS(N);
    }

    static void DFS(int n) {
        if (n < 1) return;
        DFS(n / 2);
        System.out.print(n % 2);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
