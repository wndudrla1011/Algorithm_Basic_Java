package array.소수;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int[] prime = new int[N + 1];
        int ans = 0;

        prime[0] = prime[1] = 1;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            int j = 2;
            while (i * j <= N) {
                prime[i * j]++;
                j++;
            }
        }

        for (int n : prime) {
            if (n == 0) ans++;
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
