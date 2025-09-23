package DFS_BFS_basic.피보나치수열;

import java.io.IOException;

public class Main2 {

    static int[] A;

    public static void main(String[] args) throws IOException {
        int N = readInt();
        A = new int[N + 1];
        long start = System.currentTimeMillis();

        fibonacci(N);
        for (int i = 1; i <= N; i++) System.out.print(A[i]+ " ");

        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println((end - start) / 1000.0);
    }

    static int fibonacci(int n) {
        if (n <= 2) return A[n] = 1;
        if (A[n] > 0) return A[n];
        return A[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
