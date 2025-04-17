package two_pointer.p3_4;

import java.io.IOException;

public class Main2 {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int M = readInt();
        int ans = 0;
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = readInt();
        }

        for (int i = 0; i < N - 1; i++) {
            A[i + 1] += A[i];
        }

        for (int i = N - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (A[i] - A[j] >= M) {
                    if (A[i] - A[j] == M) ans++;
                    break;
                }
            }
        }

        System.out.println(ans);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
