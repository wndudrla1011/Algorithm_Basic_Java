package array.p2_10;

import java.io.IOException;

public class Main {

    static int[][] map;
    static int[] dy = {-1, 1, 0, 0}; //상 하 좌 우
    static int[] dx = {0, 0, -1, 1}; //상 하 좌 우

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int ans = 0;
        map = new int[N + 2][N + 2];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = readInt();
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (check(i, j)) ans++;
            }
        }

        System.out.println(ans);
    }

    private static boolean check(int y, int x) {
        for (int i = 0; i < 4; i++) {
            if (map[y][x] <= map[y + dy[i]][x + dx[i]])
                return false;
        }
        return true;
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        if (n == 10) n = 0;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
