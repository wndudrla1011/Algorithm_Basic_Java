package map_tree.p4_3;

import java.io.IOException;
import java.util.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int K = readInt();
        int[] A = new int[N];
        Map<Integer, Integer> map = new HashMap<>(); //<매출, 등장 횟수>
        StringBuilder ans = new StringBuilder();
        int lt = 0;

        for (int i = 0; i < N; i++) {
            A[i] = readInt();
        }

        //첫 윈도우
        for (int i = 0; i < K - 1; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }

        for (int rt = K - 1; rt < N; rt++) {
            map.put(A[rt], map.getOrDefault(A[rt], 0) + 1);
            ans.append(map.size()).append(' ');
            map.put(A[lt], map.get(A[lt]) - 1);
            if (map.get(A[lt]) == 0) map.remove(A[lt]);
            lt++;
        }

        System.out.println(ans);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
