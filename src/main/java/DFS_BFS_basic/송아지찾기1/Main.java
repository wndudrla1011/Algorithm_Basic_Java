package DFS_BFS_basic.송아지찾기1;

import java.io.IOException;
import java.util.*;

public class Main {

    static Queue<Integer> q = new LinkedList<>();
    static boolean[] visited = new boolean[10001];
    static int[] dir = {-1, 1, 5};
    static int ans, E;

    public static void main(String[] args) throws IOException {
        int S = readInt(); //현재 위치
        E = readInt(); //송아지 위치

        System.out.println(BFS(S));
    }

    static int BFS(int S) {
        q.offer(S);
        while (true) { //반드시 답이 있다고 함
            int len = q.size();
            for (int i = 0; i < len; i++) { //해당 레벨 모두 탐색
                int x = q.poll();
//                if (x == E) return ans;
                for (int j = 0; j < 3; j++) {
                    //범위 안이고 방문 전이라면
                    int next = x + dir[j];
                    if (next > 0 && next <= 10000) {
                        if (!visited[next]) {
                            if (next == E) return ans + 1;
                            q.offer(next);
                            visited[next] = true;
                        }
                    }
                }
            }
            ans++; //다음 레벨
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
