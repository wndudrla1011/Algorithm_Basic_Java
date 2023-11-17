package DFS_BFS기초.Tree말단노드까지의가장짧은경로DFS;

public class Main {

    static int ans = 0;

    public static void main(String[] args) {
        Node root = new Node(1);
        root.lc = new Node(2);
        root.rc = new Node(3);
        root.lc.lc = new Node(4);
        root.lc.rc = new Node(5);

        DFS(root, 0);
        System.out.println(ans);
    }

    static void DFS(Node root, int dist) {
        if (root == null) {
            if (ans == 0 || ans > dist - 1) ans = dist - 1;
            return;
        }
        DFS(root.lc, dist + 1);
        DFS(root.rc, dist + 1);
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
