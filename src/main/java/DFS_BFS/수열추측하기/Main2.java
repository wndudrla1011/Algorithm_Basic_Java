package DFS_BFS.수열추측하기;

import java.io.IOException;

public class Main2 {

    static int N, F;
    static int[] ch, P, C;
    static int[][] dy;
    static boolean flag; //종료 신호

    public static void main(String[] args) throws IOException {
        N = readInt(); //가장 아래층의 숫자 개수
        F = readInt(); //가장 윗층의 숫자
        ch = new int[N + 1]; //체크 배열
        P = new int[N]; //순열 저장
        C = new int[N]; //조합 저장
        dy = new int[N][N];

        for (int i = 0; i < N; i++) {
            C[i] = comb(N - 1, i);
        }

        DFS(0, 0);
    }

    static int comb(int n, int r) { //조합 계산
        if (dy[n][r] > 0) return dy[n][r];
        if (n == r || r == 0) return 1;
        else {
            return dy[n][r] = comb(n - 1, r - 1) + comb(n - 1, r);
        }
    }

    static void DFS(int L, int sum) {
        if (flag) return;
        if (L == N) {
            if (sum == F) {
                for (int i = 0; i < N; i++) System.out.print(P[i] + " ");
                flag = true;
            }
        }
        else {
            for (int i = 1; i <= N; i++) { //오름차순 순열 생성
                if (ch[i] == 0){
                    ch[i] = 1;
                    P[L] = i;
                    DFS(L + 1, sum + (P[L] * C[L]));
                    ch[i] = 0;
                }
            }
        }

    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
