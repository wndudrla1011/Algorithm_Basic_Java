package DFS_BFS.피자배달거리;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    static int[][] A;
    static ArrayList<Loc> pz, hs;
    static int[] C;
    static int N, M, len, ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        N = readInt(); //N*N 지도
        M = readInt(); //선택할 피자집 개수
        A = new int[N][N];
        pz = new ArrayList<>(); //피자집 좌표들
        hs = new ArrayList<>(); //집 좌표들
        C = new int[M]; //선택된 피자집 조합

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = readInt();
                if (A[i][j] == 1) hs.add(new Loc(i, j));
                else if (A[i][j] == 2) pz.add(new Loc(i, j));
            }
        }

        len = pz.size(); //피자집의 개수
        DFS(0, 0);

        System.out.println(ans);
    }

    static void DFS(int L, int s) {
        if (L == M) {
            ans = Math.min(calDist(C), ans);
        }
        else {
            for (int i = s; i < len; i++) { //(len)C(M) == len개 중 M개 선택
                C[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    static int calDist(int[] C) {
        int sum = 0;
        for (Loc h : hs) { //각 집의 피자배달거리
            int dist = Integer.MAX_VALUE;
            for (int i : C) { //각 집의 피자배달거리 중 최소거리
                dist = Math.min(dist, Math.abs(h.y - pz.get(i).y) + Math.abs(h.x - pz.get(i).x));
            }
            sum += dist; //최소거리 누적
        }
        return sum; //도시의 피자배달거리
    }

    static class Loc {
        int y;
        int x;

        public Loc(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        if (n == 10) n = 0;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
