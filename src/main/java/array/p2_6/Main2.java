package array.p2_6;

import java.io.IOException;
import java.util.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        StringBuilder ans = new StringBuilder();
        int N = readInt();
        List<Integer> A = new ArrayList<>();
        int res = 0;

        for (int i = 0; i < N; i++) {
            A.add(readInt());
        }

        for (int i = 0; i < N; i++) {
            int tmp = A.get(i);
            while (tmp > 0) {
                res = res * 10 + (tmp % 10);
                tmp = tmp / 10;
            }
            if (isPrime(res)) ans.append(res).append(' ');
            res = 0;
        }

        System.out.println(ans);
    }

    private static boolean isPrime(int num) {
        if (num == 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
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
