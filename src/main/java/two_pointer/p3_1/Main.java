package two_pointer.p3_1;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int[] result;
        int p1 = 0, p2 = 0, pos = 0;

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = readInt();
        }

//        readInt();
        int M = readInt();

        int[] B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = readInt();
        }

        result = new int[N + M];
        while (p1 < N && p2 < M) {
            if (A[p1] < B[p2])
                result[pos++] = A[p1++];
            else if (A[p1] > B[p2])
                result[pos++] = B[p2++];
            else {
                result[pos++] = A[p1++];
                result[pos++] = B[p2++];
            }
        }

        while (p1 < N) result[pos++] = A[p1++];
        while (p2 < M) result[pos++] = B[p2++];

        for (int r : result) {
            System.out.print(r + " ");
        }
    }

    static int readInt() throws IOException {
        int n = 0;
        boolean isNegative = false;
        while (true) {
            int input = System.in.read();
            if (input <= 32) {
                return isNegative ? n * -1 : n;
            } else if (input == '-')
                isNegative = true;
            else
                n = (n << 3) + (n << 1) + (input & 15);
        }
    }

}
