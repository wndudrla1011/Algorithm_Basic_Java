package array.p2_5;

import java.io.IOException;

public class Main2 {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int[] prime = new int[N + 1];
        int ans = 0;

        for (int i = 2; i <= N; i++) {
            if (prime[i] == 0) {
                ans++;
                for (int j = i; j <= N; j = j + i) prime[j] = 1;
            }
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
