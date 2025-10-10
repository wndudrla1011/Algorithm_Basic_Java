package sort.p6_2;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int[] A = new int[N];
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < N; i++) {
            A[i] = readInt();
        }

        int idx = N;
        while (idx-- > 0) {
            int swapCnt = 0;
            for (int i = 0; i < idx; i++) {
                if (A[i] > A[i + 1]) {
                    swapCnt++;
                    int tmp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = tmp;
                }
            }
            if (swapCnt == 0) break;
        }

        for (int i = 0; i < N; i++) {
            ans.append(A[i]).append(" ");
        }

        System.out.println(ans);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
