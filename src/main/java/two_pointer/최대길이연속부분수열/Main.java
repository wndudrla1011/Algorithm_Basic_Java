package two_pointer.최대길이연속부분수열;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int K = readInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = readInt();
        }

        int max = 0, len = 0, cnt;
        int lt = 0, rt;
        while (lt < N) {
            rt = lt; cnt = 0; len = 0;
            while (true) {
                if (A[rt++] == 0) cnt++;
                if (cnt == K + 1) break;
                len++;
                if (rt == N) break;
            }
            if (max < len) max = len;
            lt++;
        }

        if (len > 0 && max < len) max = len;
        System.out.println(max);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
