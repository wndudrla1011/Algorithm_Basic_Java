package array.등수구하기;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int[] A = new int[N];
        int[] rank = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = readInt();
            rank[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i] < A[j]) rank[i]++;
            }
        }

        for (int r : rank) {
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
