package DFS_BFS.섬나라아일랜드;

import java.io.IOException;

public class Main {

    static int[][] A;
    static int N, ans;
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1}; //상하좌우 + 대각선 4개
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        N = readInt();
        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = readInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] == 1) { //방문 전이고 육지면
                    A[i][j] = 0;
                    DFS(i, j);
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }

    static void DFS(int y, int x) { //모든 육지 탐색
        for (int i = 0; i < 8; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
            if (A[ny][nx] == 1) {
                A[ny][nx] = 0;
                DFS(ny, nx);
            }
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        if (n == 10) n = 0; //LF 처리
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
