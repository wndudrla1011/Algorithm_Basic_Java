package DFS_BFS.섬나라아일랜드;

import java.io.IOException;
import java.util.*;

public class Main2 {

    static Queue<int[]> q = new LinkedList<>();
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
                    q.offer(new int[]{i, j});
                    BFS();
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }

    static void BFS() {
        while (!q.isEmpty()) {
            int[] elem = q.poll();
            int y = elem[0];
            int x = elem[1];
            for (int i = 0; i < 8; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                if (A[ny][nx] == 1) {
                    q.offer(new int[]{ny, nx});
                    A[ny][nx] = 0;
                }
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
