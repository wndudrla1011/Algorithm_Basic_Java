package array.p2_2;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int[] arr = new int[N];
        int max = Integer.MIN_VALUE;
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = readInt();
        }

        for (int i = 0; i < N; i++) {
            if (max < arr[i]) {
                max = arr[i];
                cnt++;
            }
        }

        System.out.println(cnt);
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
