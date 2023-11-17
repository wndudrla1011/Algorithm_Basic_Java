package DFS_BFS기초.이진트리순회_BFS;

import java.io.IOException;
import java.util.*;

public class Main2 {

    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        Node root = new Node(1);
        root.lc = new Node(2);
        root.rc = new Node(3);
        root.lc.lc = new Node(4);
        root.lc.rc = new Node(5);
        root.rc.lc = new Node(6);
        root.rc.rc = new Node(7);

        BFS(root);
    }

    static void BFS(Node root) {
        q.offer(root);
        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            System.out.print(L + " : ");
            for (int i = 0; i < len; i++) {
                Node cur = q.poll();
                System.out.print(cur.v + " ");
                if (cur.lc != null) q.offer(cur.lc);
                if (cur.rc != null) q.offer(cur.rc);
            }
            L++;
            System.out.println();
        }
    }

    static class Node {
        int v;
        Node lc;
        Node rc;

        public Node(int v) {
            this.v = v;
            this.lc = null;
            this.rc = null;
        }
    }

}
