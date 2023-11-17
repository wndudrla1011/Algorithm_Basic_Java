package DFS_BFS기초.이진트리순회_DFS;

import java.io.IOException;

public class Main {

    static Node[] A;

    public static void main(String[] args) throws IOException {
        int N = readInt();
        A = new Node[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new Node(readInt(), readInt(), readInt());
        }

        preorder(1);
        System.out.println();
        inorder(1);
        System.out.println();
        postorder(1);
    }

    static void preorder(int v) {
        if (v > 0) System.out.print(v + " ");
        if (v == 0) return;
        preorder(A[v].lc);
        preorder(A[v].rc);
    }

    static void inorder(int v) {
        if (v == 0) return;
        inorder(A[v].lc);
        System.out.print(v + " ");
        inorder(A[v].rc);
    }

    static void postorder(int v) {
        if (v == 0) return;
        postorder(A[v].lc);
        postorder(A[v].rc);
        System.out.print(v + " ");
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
