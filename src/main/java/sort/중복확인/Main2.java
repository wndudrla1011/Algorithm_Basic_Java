package sort.중복확인;

import java.io.IOException;
import java.util.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        char ans = 'U';
        int N = readInt();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int n = readInt();
            if (!map.containsKey(n))
                map.put(n, map.getOrDefault(n, 0) + 1);
            else {
                ans = 'D';
                break;
            }
        }

        System.out.println(ans);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
