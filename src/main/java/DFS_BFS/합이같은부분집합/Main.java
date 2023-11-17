package DFS_BFS.합이같은부분집합;

import java.io.IOException;
import java.util.*;

public class Main {

    static int[] visited; //방문체크
    static int[] A;
    static int N, total;
    static String ans = "NO";

    public static void main(String[] args) throws IOException {
        N = readInt();
        A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = readInt();
            total += A[i];
        }

        Arrays.sort(A);
        visited = new int[A[N - 1] + 1]; //각 원소 값 == index

        for (int i = 0; i < N; i++) {
            visited[A[0]] = 1;
            DFS(A[i], A[i]);
        }
        System.out.println(ans);
    }

    static void DFS(int v, int sum) {
        if (total - sum == sum) ans = "YES";
        if (ans.equals("YES")) return;
        for (int i = 0; i < N; i++) {
            if (visited[A[i]] == 0 && v < A[i]) {
                visited[A[i]] = 1;
                DFS(A[i], sum + A[i]);
                visited[A[i]] = 0;
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
