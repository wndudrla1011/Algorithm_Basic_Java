package sort.중복확인;

import java.io.IOException;
import java.util.Arrays;

public class Main3 {

    public static void main(String[] args) throws IOException {
        char ans = 'U';
        int N = readInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = readInt();
        }

        Arrays.sort(A);

        for (int i = 0; i < N - 1; i++) {
            if (A[i] == A[i + 1]) {
                ans = 'D';
                break;
            }
        }

        System.out.println(ans);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
