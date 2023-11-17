package greedy.원더랜드;

import java.io.IOException;
import java.util.*;

public class Main {

    static int V; //도시의 개수
    static int E; //도로의 개수
    static ArrayList<Edge> A; //에지 리스트
    static int[] UF; //유니온-파인드 배열
    static boolean flag; //사이클 여부

    public static void main(String[] args) throws IOException {
        V = readInt();
        E = readInt();
        A = new ArrayList<>();
        UF = new int[V + 1];
        int ans = 0;
        int edge_cnt = 0; //연결되는 에지 개수

        for (int i = 0; i < E; i++) {
            int a = readInt();
            int b = readInt();
            int c = readInt();
            A.add(new Edge(a, b, c));
        }

        //유니온 파인드 배열 초기화
        for (int i = 1; i <= V; i++) UF[i] = i;

        Collections.sort(A);

        for (int i = 0; i < E; i++) {
            int a = A.get(i).start;
            int b = A.get(i).end;
            union(a, b);
            if (flag) {
                ans += A.get(i).weight; //사이클이 없으므로 연결
                edge_cnt++; //에지 추가
            }
            if (edge_cnt == V - 1) break; //에지 개수 == 노드 개수 - 1
        }

        System.out.println(ans);
    }

    static void union(int a, int b) {
        flag = false;
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return; //사이클
        flag = true;
        if (pa < pb) UF[pb] = pa;
        else UF[pa] = pb;
    }

    static int find(int a) {
        if (a == UF[a]) return a;
        else return UF[a] = find(UF[a]);
    }

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight; //가중치 오름차순
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
