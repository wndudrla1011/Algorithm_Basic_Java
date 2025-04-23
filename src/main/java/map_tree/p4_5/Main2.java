package map_tree.p4_5;

import java.io.IOException;
import java.util.*;

public class Main2 {

    static Set<Integer> set = new TreeSet<>(Comparator.reverseOrder());

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int K = readInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) A[i] = readInt();

        if (N < K) {
            System.out.println(-1);
            return;
        }

        Comb(A, 0, 0, 0);

        int cnt = 0;
        for (int v : set) {
            cnt++;
            if (cnt == K) {
                System.out.println(v);
                return;
            }
        }
    }

    static void Comb(int[] A, int S, int r, int sum) {
        if (r == 3) {
            set.add(sum);
            return;
        }

        for (int i = S; i < A.length; i++) {
            sum += A[i];
            Comb(A, i + 1, r + 1, sum);
            sum -= A[i];
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
