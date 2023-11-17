package DFS_BFS기초.피보나치수열;

import java.io.IOException;

public class Main3 {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int[] A = new int[N + 1];
        long start = System.currentTimeMillis();

        A[1] = 1; A[2] = 1;
        for (int i = 3; i <= N; i++) {
            A[i] = A[i - 1] + A[i - 2];
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(A[i] + " ");
        }

        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println((end - start) / 1000.0);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
