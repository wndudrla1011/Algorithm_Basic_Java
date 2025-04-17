package two_pointer.p3_6;

import java.io.IOException;

public class Main2 {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int K = readInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = readInt();
        }

        int max = 0, cnt = 0, lt = 0;
        for (int rt = 0; rt < N; rt++) {
            if (A[rt] == 0) cnt++;
            while (cnt > K) {
                if (A[lt] == 0) cnt--;
                lt++;
            }
            max = Math.max(max, rt - lt + 1);
        }

        System.out.println(max);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
