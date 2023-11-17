package DFS_BFS기초.경로탐색_인접리스트;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    static ArrayList<Integer>[] graph;
//    static ArrayList<ArrayList<Integer>> graph;
    static int N, ans;
    static boolean[] visited; //방문 체크

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        N = readInt(); //정점의 수
        int M = readInt(); //간선의 수
        graph = new ArrayList[N + 1];
//        graph = new ArrayList<>();
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
//            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int s = readInt();
            int e = readInt();
            graph[s].add(e);
//            graph.get(s).add(e);
        }

        DFS(1);
        System.out.println(ans);

        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println((end - start) / 1000.0);
    }

    static void DFS(int v) {
        visited[v] = true;
        if (v == N) {
            ans++;
            return;
        }

        for (int i : graph[v]) {
            if (!visited[i]) {
                DFS(i);
                visited[i] = false;
            }
        }

//        for (int i : graph.get(v)) {
//            if (!visited[i]) {
//                DFS(i);
//                visited[i] = false;
//            }
//        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
