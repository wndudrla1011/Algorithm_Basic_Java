package sort.선택정렬;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int[] A = new int[N];
        StringBuilder ans = new StringBuilder();
        int min;

        for (int i = 0; i < N; i++) {
            A[i] = readInt();
        }

        for (int i = 0; i < N - 1; i++) {
            min = i;
            for (int j = i + 1; j < N; j++) {
                if (A[min] > A[j]) min = j;
            }
            int tmp = A[i];
            A[i] = A[min];
            A[min] = tmp;
        }

        for (int i = 0; i < N; i++) {
            ans.append(A[i]).append(" ");
        }

        System.out.println(ans);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
