package array.p2_6;

import java.io.IOException;

public class Main3 {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int[] prime;
        int[] arr = new int[N + 1];
        int boundary = Integer.MIN_VALUE;
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int num = readInt();
            int len = String.valueOf(num).length() - 1;
            int val = 0;
            while (len > -1) { // 숫자 뒤집기
                val += (num % 10) * (int) Math.pow(10, len);
                num /= 10;
                len--;
            }

            boundary = Math.max(boundary, val);
            arr[i] = val;
        }

        prime = new int[boundary + 1];

        //에라토스테네스의 체
        prime[0] = prime[1] = 1;
        for (int i = 2; i <= boundary; i++) {
            int j = 2;
            while (i * j <= boundary) {
                prime[i * j] = 1;
                j++;
            }
        }

        for (int o : arr) {
            if (prime[o] == 0) ans.append(o).append(" ");
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
