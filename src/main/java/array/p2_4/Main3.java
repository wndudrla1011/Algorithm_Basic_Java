package array.p2_4;

import java.io.IOException;

public class Main3 {

    static int[] memo;

    public static void main(String[] args) throws IOException {
        int N = readInt();
        memo = new int[N + 1];

        for (int i = 1; i <= 10; i++) {
            System.out.print(fibonacci(i) + " ");
        }

        System.out.println();
    }

    static int fibonacci(int n) {
        if (memo[n] != 0) return memo[n]; // memoization
        else if (n == 1 || n == 2) return memo[n] = 1;
        return memo[n] = fibonacci(n - 1) + fibonacci(n - 2);
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
