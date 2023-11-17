package DFS_BFS.토마토;

import java.io.IOException;
import java.util.*;

public class Main {

    static Queue<int[]> q = new LinkedList<>();
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] A;
    static int M, N;

    public static void main(String[] args) throws IOException {
        M = readInt(); //열
        N = readInt(); //행
        A = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                A[i][j] = readInt();
            }
            readInt(); //LF 처리
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (A[i][j] == 1) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        if (q.size() == 0) { //익은 토마토가 없는 경우
            System.out.println(0);
            return;
        }

        BFS();

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (A[i][j] == 0) { //모든 토마토가 익지 않은 경우
                    System.out.println(-1);
                    return;
                }
                if (ans < A[i][j]) ans = A[i][j];
            }
        }

        System.out.println(ans - 1);
    }

    static void BFS() {
        while (!q.isEmpty()) {
            int[] cur = q.poll(); //현재 좌표
            int y = cur[0];
            int x = cur[1];
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 1 || ny > N || nx < 1 || nx > M) continue;
                if (A[ny][nx] == 0) { //다음 방문 좌표
                    q.offer(new int[]{ny, nx});
                    A[ny][nx] = A[y][x] + 1;
                }
            }
        }
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
