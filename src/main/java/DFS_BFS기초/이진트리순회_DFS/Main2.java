package DFS_BFS기초.이진트리순회_DFS;

import java.io.IOException;

public class Main2 {

    public static void main(String[] args) throws IOException {
        Node root = new Node(1);
        root.lc = new Node(2);
        root.rc = new Node(3);
        root.lc.lc = new Node(4);
        root.lc.rc = new Node(5);
        root.rc.lc = new Node(6);
        root.rc.rc = new Node(7);

        DFS(root);
    }

    static void DFS(Node root) {
        if (root == null) return;
        else {
//            System.out.print(root.v + " "); //preorder
            DFS(root.lc);
//            System.out.print(root.v + " "); //inorder
            DFS(root.rc);
            System.out.print(root.v + " "); //postorder
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
