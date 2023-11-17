package sort.장난꾸러기;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int[] A = new int[N]; //원본
        int[] C; //정렬
        int ans1 = 0, ans2 = 0; //ans1 : 철수, ans2 : 짝

        for (int i = 0; i < N; i++) {
            A[i] = readInt();
        }

        C = Arrays.copyOfRange(A, 0, N);
        Arrays.sort(C);

        for (int i = 0; i < N; i++) {
            if (C[i] != A[i]) {
                if (ans1 == 0) ans1 = i + 1;
                else ans2 = i + 1;
            }
        }

        System.out.println(ans1 + " " + ans2);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
