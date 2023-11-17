package two_pointer.연속부분수열;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int M = readInt();
        int[] A = new int[N];
        int lt = 0, rt = 0, sum = 0, ans = 0;

        for (int i = 0; i < N; i++) {
            A[i] = readInt();
        }

        while (true) {
            if (sum >= M) {
                if (sum == M) ans++;
                sum -= A[lt++];
            }
            else if (rt >= N) break;
            else sum += A[rt++];
        }

        System.out.println(ans);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
