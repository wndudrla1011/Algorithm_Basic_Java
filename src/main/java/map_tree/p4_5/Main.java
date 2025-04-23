package map_tree.p4_5;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int K = readInt();
        int[] A = new int[N];
        Set<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++)
            A[i] = readInt();

        if (N < K) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    set.add(A[i] + A[j] + A[k]);
                }
            }
        }

        System.out.println(set.toArray()[K - 1]);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
