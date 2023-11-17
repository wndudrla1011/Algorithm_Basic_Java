package DFS_BFS.최대점수구하기;

import java.io.IOException;

public class Main {

    static Node[] A;
    static int N, M, ans;

    public static void main(String[] args) throws IOException {
        N = readInt(); //문제 개수
        A = new Node[N];
        M = readInt(); //총 제한시간

        for (int i = 0; i < N; i++) {
            A[i] = new Node(readInt(), readInt());
        }

        DFS(0, 0, 0);
        System.out.println(ans);
    }

    static void DFS(int L, int sum, int time) {
        if (time > M) return;
        if (L == N) ans = Math.max(sum, ans);
        else {
            DFS(L + 1, sum + A[L].point, time + A[L].limit);
            DFS(L + 1, sum, time);
        }
    }

    static class Node {
        int point;
        int limit;

        public Node(int point, int limit) {
            this.point = point;
            this.limit = limit;
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
