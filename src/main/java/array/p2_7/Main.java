package array.p2_7;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int[] A = new int[N];
        int seq = 0, ans = 0;

        for (int i = 0; i < N; i++) {
            A[i] = readInt();
        }

        for (int i = 0; i < N; i++) {
            if (A[i] == 1) ans += ++seq;
            else seq = 0;
        }

        System.out.println(ans);
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
