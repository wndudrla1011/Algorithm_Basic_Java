package sort.버블정렬;

import java.io.IOException;

public class Main2 {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int[] A = new int[N];
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < N; i++) {
            A[i] = readInt();
        }

        for (int i = 0; i < N - 1; i++){
            int swapCnt = 0;
            for (int j = 0; j < N - 1 - i; j++) {
                if (A[j] > A[j + 1]) {
                    swapCnt++;
                    int tmp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = tmp;
                }
            }
            if (swapCnt == 0) break;
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
