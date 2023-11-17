package DFS_BFS.미로의최단거리통로;

import java.io.IOException;
import java.util.*;

public class Main {

    static Queue<int[]> q = new LinkedList<>();
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] visited = new int[8][8];
    static int[][] A = new int[8][8];
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                A[i][j] = readInt();
            }
        }

        visited[1][1] = 1;
        q.add(new int[]{1, 1, 0});
        BFS();
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static void BFS() {
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int y = node[0];
            int x = node[1];
            int cnt = node[2];
            if (y == 7 && x == 7) ans = Math.min(ans, cnt);
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 1 || ny >= 8 || nx < 1 || nx >= 8) continue;
                if (visited[ny][nx] == 0 && A[ny][nx] == 0) {
                    visited[ny][nx] = 1;
                    q.add(new int[]{ny, nx, cnt + 1});
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
