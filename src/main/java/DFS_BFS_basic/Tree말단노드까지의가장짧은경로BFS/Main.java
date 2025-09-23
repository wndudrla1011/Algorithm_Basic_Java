package DFS_BFS_basic.Tree말단노드까지의가장짧은경로BFS;

import java.util.*;

public class Main {

    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) {
        Node root = new Node(1);
        root.lc = new Node(2);
        root.rc = new Node(3);
        root.lc.lc = new Node(4);
        root.lc.rc = new Node(5);

        System.out.println(BFS(root));
    }

    static int BFS(Node root) {
        q.offer(root);
        int depth = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node cur = q.poll();
                if (cur.lc == null && cur.rc == null) return depth;
                if (cur.lc != null) q.offer(cur.lc);
                if (cur.rc != null) q.offer(cur.rc);
            }
            depth++;
        }
        return depth;
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
