package sort.이분검색;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int M = readInt(); //target
        int[] A = new int[N];
        int ans = 0;

        for (int i = 0; i < N; i++) {
            A[i] = readInt();
        }

        Arrays.sort(A);

        int left = 0, right = N - 1, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (M < A[mid]) right = mid - 1;
            else if (M > A[mid]) left = mid + 1;
            else {
                ans = mid + 1;
                break;
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
