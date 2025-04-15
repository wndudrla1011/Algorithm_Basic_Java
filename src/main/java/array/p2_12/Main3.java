package array.p2_12;

import java.io.IOException;
import java.util.*;

public class Main3 {

    public static void main(String[] args) throws IOException {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int N = readInt();
        int M = readInt();
        int[][] A = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = readInt();
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) { //target
                for (int k = j + 1; k < N; k++) { //compare
                    int target = A[i][j];
                    int compare = A[i][k];
                    if (i == 0) { //input relations
                        map.computeIfAbsent(target, key -> new ArrayList<>()).add(compare);
                    }
                    else {
                        if (map.containsKey(compare)) { //there's reverse case
                            List<Integer> list = map.get(compare);
                            list.remove((Integer) target); //remove reverse case
                        }
                    }
                }
            }
        }

        int cnt = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            cnt += entry.getValue().size();
        }

        System.out.println(cnt);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
