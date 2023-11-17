package sort.마구간정하기;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt(); //좌표 수
        int C = readInt(); //배치할 말 수
        int[] A = new int[N];
        int max_dist = 0;

        for (int i = 0; i < N; i++) {
            A[i] = readInt();
        }

        Arrays.sort(A);

        int left = 1, right = A[N - 1], mid;
        int cnt, ep;
        while (left <= right) {
            mid = (left + right) / 2;
            cnt = 1; ep = A[0];
            for (int i = 1; i < N; i++) {
                if (A[i] - ep >= mid) {
                    ep = A[i];
                    cnt++;
                }
            }
            if (cnt < C) right = mid - 1;
            else {
                max_dist = mid;
                left = mid + 1;
            }
        }

        System.out.println(max_dist);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
