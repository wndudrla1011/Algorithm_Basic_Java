package DFS_BFS.순열구하기;

import java.io.IOException;

public class Main {

    static int N, M;
    static int[] I, A, ch;

    public static void main(String[] args) throws IOException {
        N = readInt(); //입력 개수
        M = readInt(); //뽑는 개수
        I = new int[N]; //입력 저장
        A = new int[M]; //뽑은 값 저장
        ch = new int[N]; //체크 배열

        for (int i = 0; i < N; i++) {
            I[i] = readInt();
        }

        DFS(0);
    }

    static void DFS(int L) { //L: 뽑은 개수
        if (L == M) {
            for (int n : A) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
        else {
            for (int i = 0; i < N; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    A[L] = I[i];
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
