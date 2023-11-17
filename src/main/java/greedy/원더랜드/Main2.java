package greedy.원더랜드;

import java.io.IOException;
import java.util.*;

public class Main2 {

    static int V; //도시의 개수
    static int E; //도로의 개수
    static ArrayList<Edge>[] A; //에지 리스트
    static int[] ch; //방문 배열
    static int ans; //최소 경로
    static PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));

    public static void main(String[] args) throws IOException {
        V = readInt();
        E = readInt();
        A = new ArrayList[V + 1];
        ch = new int[V + 1];
        ans = 0;

        for (int i = 1; i <= V; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int a = readInt();
            int b = readInt();
            int c = readInt();
            A[a].add(new Edge(b, c));
            A[b].add(new Edge(a, c));
        }

        pq.offer(new Edge(1, 0));
        Prim();

        System.out.println(ans);
    }

    static void Prim() {
        int ch_cnt = 0; //모든 정점 방문 여부
        while (!pq.isEmpty() && ch_cnt < V) {
            Edge n = pq.poll();
            if (ch[n.end] == 0) { //방문 전
                ch[n.end] = 1;
                ch_cnt++;
                ans += n.weight; //경로 계산
                for (Edge edge : A[n.end]) //방문 장소랑 연결된 경로
                    if (ch[edge.end] == 0) pq.offer(edge); //방문 전
            }
        }
    }

    static class Edge {
        int end;
        int weight;

        public Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
