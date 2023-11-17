package DFS_BFS.수열추측하기;

import java.io.IOException;

public class Main {

    static int N, F;
    static int[] ch; //체크 배열
    static int[] P; //순열 저장

    public static void main(String[] args) throws IOException {
        N = readInt(); //가장 아래층의 숫자 개수
        F = readInt(); //가장 윗층의 숫자
        ch = new int[N + 1];
        P = new int[N];

        DFS(0);
    }

    static void DFS(int L) {
        if (L == N) {
            int len = N - 1;
            int[] A = new int[N]; //각 순열 원소끼리 계산한 값 저장(일회용)
            System.arraycopy(P, 0, A, 0, N); //P -> A 복사
            while (len > 0) { //파스칼 계산
                for (int i = 0; i < len; i++) {
                    A[i] = A[i] + A[i + 1];
                }
                len--;
            }
            if (A[0] == F) {
                for (int v : P) System.out.print(v + " ");
                System.exit(0);
            }
        }
        else {
            for (int i = 1; i <= N; i++) { //오름차순 순열 생성
                if (ch[i] == 0){
                    ch[i] = 1;
                    P[L] = i;
                    DFS(L + 1);
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
