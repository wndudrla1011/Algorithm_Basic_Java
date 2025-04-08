package array.p2_1;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int[] arr = new int[N];
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < N; i++)
            arr[i] = readInt();

        for (int i = 0; i < N; i++) {
            if (i == 0) {
                ans.append(arr[i]).append(' ');
                continue;
            }
            if (arr[i - 1] < arr[i])
                ans.append(arr[i]).append(' ');
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
