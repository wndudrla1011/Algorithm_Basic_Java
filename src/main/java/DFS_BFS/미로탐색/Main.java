package DFS_BFS.미로탐색;

import java.io.IOException;

public class Main {

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] visited = new int[8][8];
    static int[][] A = new int[8][8];
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                A[i][j] = readInt();
            }
        }

        DFS(1, 1);
        System.out.println(ans);
    }

    static void DFS(int y, int x) {
        visited[y][x] = 1;
        if (y == 7 && x == 7) {
            ans++;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 1 || ny >= 8 || nx < 1 || nx >= 8) continue;
            if (visited[ny][nx] == 0 && A[ny][nx] == 0) {
                DFS(ny, nx);
                visited[ny][nx] = 0;
            }
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
