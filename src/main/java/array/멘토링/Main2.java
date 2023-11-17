package array.멘토링;

import java.io.IOException;

public class Main2 {

    public static void main(String[] args) throws IOException {
        int N = readInt(); //학생 수
        int M = readInt(); //테스트 결과
        int[][] A = new int[M + 1][N + 1];
        int ans = 0;

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                A[i][j] = readInt();
            }
        }

        for (int i = 1; i <= N; i++) { //i번 학생
            for (int j = 1; j <= N; j++) { //j번 학생
                /*
                * (i, j) 경우가 모든 행에서 만족하는가
                * 즉, i 등수 < j 등수 (카운팅)
                * 카운팅 횟수 == M (모든 행에서 만족한 것)
                * */
                int cnt = 0;
                for (int k = 1; k <= M; k++) {
                    int pi = 0, pj = 0; //pi : i의 등수, pj : j의 등수
                    for (int s = 1; s <= N; s++) { //등수
                        if (A[k][s] == i) pi = s; //i 학생의 등수
                        if (A[k][s] == j) pj = s; //j 학생의 등수
                    }
                    if (pi < pj) cnt++;
                }
                if (cnt == M) ans++;
            }
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
