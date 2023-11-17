package DFS_BFS기초.부분집합구하기;

import java.io.IOException;

public class Main {

    static int[] visited;
    static int N;

    public static void main(String[] args) throws IOException {
        N = readInt();
        visited = new int[N + 1];

        DFS(1);
    }

    static void DFS(int n) {
        if (n > N) {
            for (int i = 1; i <= N; i++) {
                if (visited[i] == 1) System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        visited[n] = 1;
        DFS(n + 1);
        visited[n] = 0;
        DFS(n + 1);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
