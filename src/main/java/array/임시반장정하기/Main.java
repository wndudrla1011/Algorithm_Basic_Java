package array.임시반장정하기;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int[][] check = new int[N + 1][N + 1];
        int[][] A = new int[N + 1][6];
        int max = Integer.MIN_VALUE, ans = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 5; j++) {
                A[i][j] = readInt();
            }
        }

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= N; j++) {
                int target = A[j][i];
                for (int k = j + 1; k <= N; k++) {
                    if (target == A[k][i]) { //같은 반
                        if (check[j][k] == 0) { //중복 체크 방지
                            check[j][k] = 1; //j번 학생 기준 체크
                            check[k][j] = 1; //k번 학생 기준 체크
                        }
                    }
                }
            }
        }

        int cnt; //각 학생별 짝꿍 횟수 카운팅
        for (int i = 1; i <= N; i++) {
            cnt = 0;
            for (int j = 1; j <= N; j++) {
                if (check[i][j] == 1) cnt++;
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
