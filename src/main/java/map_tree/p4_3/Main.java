package map_tree.p4_3;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int K = readInt();
        int[] A = new int[N];
        Map<Integer, Integer> map = new HashMap<>(); //<매출, 등장 횟수>
        StringBuilder ans = new StringBuilder();
        int lt = 0, rt, cnt = 0;

        for (int i = 0; i < N; i++) {
            A[i] = readInt();
        }

        //첫 윈도우
        for (rt = 0; rt < K; rt++) {
            map.put(A[rt], map.getOrDefault(A[rt], 0) + 1);
            if (map.get(A[rt]) == 1) cnt++;
        }
        ans.append(cnt).append(' ');

        while (rt < N) {
            map.put(A[lt], map.get(A[lt]) - 1);
            if (map.get(A[lt++]) == 0) cnt--;
            map.put(A[rt], map.getOrDefault(A[rt], 0) + 1);
            if (map.get(A[rt++]) == 1) cnt++;
            ans.append(cnt).append(' ');
        }

        System.out.println(ans);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
