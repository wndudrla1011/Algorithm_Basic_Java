package array.p2_4;

import java.io.IOException;

public class Main2 {

    static StringBuilder ans = new StringBuilder();
    static int N;

    public static void main(String[] args) throws IOException {
        N = readInt();
        int num1 = 1, num2 = 1;

        ans.append(1).append(" ").append(1).append(" ");
        N = N - 2;

        fibonacci(N, num1, num2);

        System.out.println(ans);
    }

    static void fibonacci(int recur, int a, int b) {
        if (recur == 0) return;
        else {
            ans.append(a + b).append(" ");
            fibonacci(recur - 1, b, a + b);
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
