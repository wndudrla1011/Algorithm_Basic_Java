package two_pointer.최대매출;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int K = readInt();
        int[] A = new int[N];
        int max;

        for (int i = 0; i < N; i++) {
            A[i] = readInt();
        }

        int lt = 0, rt = K, sum = 0;

        for (int i = 0; i < K; i++) {
            sum += A[i];
        }

        max = sum;

        while (rt < N) {
            sum = sum + A[rt++] - A[lt++];
            if (max < sum) max = sum;
        }

        System.out.println(max);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        if (n == 10) n = 0;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
