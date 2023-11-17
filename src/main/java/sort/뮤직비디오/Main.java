package sort.뮤직비디오;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int M = readInt();
        int[] A = new int[N];
        int left = 0, right = 0;

        for (int i = 0; i < N; i++) {
            A[i] = readInt();
            if (left < A[i]) left = A[i];
            right += A[i];
        }

        int ans = right;
        int mid = 0, sum, set;
        while (left <= right) {
            mid = (left + right) / 2;
            sum = 0; set = 0;
            for (int i = 0; i < N; i++) {
                if (sum + A[i] <= mid) {
                    sum += A[i];
                } else {
                    set++;
                    sum = A[i];
                }
            }
            set++;
            if (set > M) left = mid + 1;
            else {
                ans = mid;
                right = mid - 1;
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
