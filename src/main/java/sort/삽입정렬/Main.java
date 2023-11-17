package sort.삽입정렬;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int[] A = new int[N];
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < N; i++) {
            A[i] = readInt();
        }

        for (int i = 1; i < N; i++) {
            int insertion_point = i;
            int insertion_value = A[i];
            for (int j = i - 1; j >= 0; j--) {
                if (A[j] < A[i]) {
                    insertion_point = j + 1;
                    break;
                }
                if (j == 0) insertion_point = 0;
            }
            for (int j = i; j > insertion_point; j--) {
                A[j] = A[j - 1];
            }
            A[insertion_point] = insertion_value;
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
