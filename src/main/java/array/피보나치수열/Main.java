package array.피보나치수열;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int[] arr = new int[N];

        arr[0] = arr[1] = 1;

        for (int i = 2; i < N; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    static int readInt() throws IOException {
        int result;
        int n = 0;
        boolean isNegative = false;
        while (true) {
            int input = System.in.read();
            if (input <= 32) {
                result = isNegative ? n * -1 : n;
                break;
            } else if (input == '-')
                isNegative = true;
            else
                n = (n << 3) + (n << 1) + (input & 15);
        }
        return result;
    }

}
