package array.p2_11;

import java.io.IOException;

public class Main2 {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int[][] A = new int[N + 1][6];
        int max = Integer.MIN_VALUE, ans = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 5; j++) {
                A[i][j] = readInt();
            }
        }

        for (int i = 1; i <= N; i++) { //학생1
            int cnt = 0; //i번 학생의 짝꿍 수 (1~5학년)
            for (int j = 1; j <= N; j++) { //학생2
                for (int k = 1; k <= 5; k++) { //학년
                    if (A[i][k] == A[j][k]) { //같은 반
                        cnt++;
                        break; //1회만 체크
                    }
                }
            }
            if (max < cnt) {
                max = cnt;
                ans = i;
            }
        }

        System.out.println(ans);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        if (n == 10) n = 0;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
