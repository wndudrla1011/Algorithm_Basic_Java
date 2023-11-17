package DFS_BFS기초.이진트리순회_BFS;

import java.io.IOException;
import java.util.*;

public class Main {

    static Node[] A;
    static Queue<Integer> q = new LinkedList<>();
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = readInt();
        A = new Node[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new Node(readInt(), readInt(), readInt());
        }

        q.offer(1);
        BFS();
        System.out.println(ans);
    }

    static void BFS() {
        while (!q.isEmpty()) {
            int x = q.poll();
            ans.append(x).append(" ");
            if (A[x].lc > 0) q.offer(A[x].lc);
            if (A[x].rc > 0) q.offer(A[x].rc);
        }
    }

    static class Node {
        int v;
        int lc;
        int rc;

        public Node(int v, int lc, int rc) {
            this.v = v;
            this.lc = lc;
            this.rc = rc;
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
