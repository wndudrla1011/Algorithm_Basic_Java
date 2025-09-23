package DFS_BFS_basic.Tree말단노드까지의가장짧은경로DFS;

public class Main2 {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.lc = new Node(2);
        root.rc = new Node(3);
        root.lc.lc = new Node(4);
        root.lc.rc = new Node(5);

        System.out.println(DFS(root, 0));
    }

    static int DFS(Node root, int dist) {
        if (root.lc == null && root.rc == null) return dist;
        else return Math.min(DFS(root.lc, dist + 1), DFS(root.rc, dist + 1));
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
