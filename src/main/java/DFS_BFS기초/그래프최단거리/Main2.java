package DFS_BFS기초.그래프최단거리;

import java.io.IOException;
import java.util.*;

public class Main2 {

    static ArrayList<Integer>[] A;
    static int[] visited; //방문 체크
    static int[] dist; //각 정점(index)까지의 거리
    static int N;

    public static void main(String[] args) throws IOException {
        N = readInt(); //정점의 수
        int M = readInt(); //간선의 수
        A = new ArrayList[N + 1];
        dist = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int s = readInt();
            int e = readInt();
            A[s].add(e);
        }

        for (int i = 2; i <= N; i++) {
            System.out.println(i + " : " + BFS(i));
        }
    }

    static int BFS(int target) {
        Queue<Integer> q = new LinkedList<>();
        visited = new int[N + 1];
        q.offer(1);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int V = q.poll(); //현재 정점
                for (int next : A[V]) { //i: 도달 가능한 정점
                    if (visited[next] == 0) { //방문 전
                        visited[next] = 1;
                        dist[next] = dist[V] + 1; //이동
                        q.offer(next);
                    }
                    if (next == target) return dist[next]; //타깃 찾음
                }
            }
        }
        return -1; //도달 불가능
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
