package sort.LeastRecentlyUsed;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder ans = new StringBuilder();
        int S = readInt(); //캐시의 크기
        int N = readInt(); //작업의 개수
        int[] cache = new int[S + 1];
        int idx;

        for (int i = 0; i < N; i++) {
            int w = readInt();
            idx = 0;
            for (int j = 0; j < S; j++) {
                if (w == cache[j]) { //Cache Hit
                    if (j > 0) {
                        idx = j;
                        break;
                    }
                }
                if (j == S - 1) idx = S; //Cache Miss
            }
            //Shift Right
            for (int j = idx; j > 0; j--) {
                cache[j] = cache[j - 1];
            }
            cache[0] = w;
        }

        for (int i = 0; i < S; i++) {
            ans.append(cache[i]).append(" ");
        }

        System.out.println(ans);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
