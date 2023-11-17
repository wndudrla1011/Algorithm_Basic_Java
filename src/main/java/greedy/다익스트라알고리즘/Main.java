package greedy.다익스트라알고리즘;

import java.io.IOException;
import java.util.*;

public class Main {

    static ArrayList<Edge>[] A; //인접 리스트
    static int[] dist; //최단 거리 배열 (1번 노드에서 각 노드까지의 최단 거리)

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int M = readInt();
        A = new ArrayList[N + 1];
        dist = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            int s = readInt();
            int e = readInt();
            int w = readInt();
            A[s].add(new Edge(e, w));
        }

        dijkstra();

        for (int i = 2; i <= N; i++) {
            if (dist[i] != Integer.MAX_VALUE)
                System.out.println(i + " : " + dist[i]);
            else
                System.out.println(i + " : impossible");
        }
    }

    static void dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>(); //현재 구해진 최단 거리 정보
        dist[1] = 0; //1번 노드에서 각 정점까지의 거리
        pq.offer(new Edge(1, 0));
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int vex = cur.dst;
            int cost = cur.cost;
            if (cost > dist[vex]) continue; //더 큰 비용이 드는 경로
            for (Edge edge : A[vex]) { //vex 와 연결된 정점
                /**
                 * 기존의 최단 거리보다 적은 거리를 찾으면 갱신
                 * cost : 1번 노드에서 현재 정점(vex)까지의 거리
                 * edge.cost : 현재 정점에서 다음 정점(edge.dst)까지의 거리
                 * dist[edge.dst] : 이미 구해진 다음 정점까지의 최단 거리
                 **/
                if (cost + edge.cost < dist[edge.dst]) {
                    dist[edge.dst] = cost + edge.cost;
                    pq.offer(new Edge(edge.dst, cost + edge.cost));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int dst; //목적지
        int cost; //비용

        public Edge(int dst, int cost) {
            this.dst = dst;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost; //비용 오름차순
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
