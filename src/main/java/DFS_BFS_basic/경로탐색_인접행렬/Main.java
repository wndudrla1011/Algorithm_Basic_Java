package DFS_BFS_basic.경로탐색_인접행렬;

import java.io.IOException;

public class Main {

    static int[][] graph;
    static int N, ans;
    static boolean[] visited; //방문 체크

    public static void main(String[] args) throws IOException {
        N = readInt(); //정점의 수
        int M = readInt(); //간선의 수
        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            int s = readInt();
            int e = readInt();
            graph[s][e] = 1;
        }

        DFS(1);
        System.out.println(ans);
    }

    static void DFS(int v) {
        visited[v] = true;
        if (v == N) {
            ans++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (graph[v][i] == 1 && !visited[i]) {
                DFS(i);
                visited[i] = false;
            }
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
