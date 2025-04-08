package array.p2_3;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int[] A = new int[N];
        int[] B = new int[N];
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < N; i++) {
            A[i] = readInt();
        }

        readInt();

        for (int i = 0; i < N; i++) {
            B[i] = readInt();
        }

        for (int i = 0; i < N; i++) {
            if (A[i] == 1) {
                if (B[i] == 1) ans.append('D').append('\n');
                else if (B[i] == 2) ans.append('B').append('\n');
                else ans.append('A').append('\n');
            } else if (A[i] == 2) {
                if (B[i] == 1) ans.append('A').append('\n');
                else if (B[i] == 2) ans.append('D').append('\n');
                else ans.append('B').append('\n');
            } else {
                if (B[i] == 1) ans.append('B').append('\n');
                else if (B[i] == 2) ans.append('A').append('\n');
                else ans.append('D').append('\n');
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
