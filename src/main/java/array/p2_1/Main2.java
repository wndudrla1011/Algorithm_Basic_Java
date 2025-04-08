package array.p2_1;

import java.io.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        int N = readInt(); // 입력 개수
        int prev, cur;
        StringBuilder ans = new StringBuilder();

        prev = readInt();
        ans.append(prev);
        N--;

        while (N-- > 0) {
            cur = readInt();
            if (prev < cur) ans.append(" ").append(cur);
            prev = cur;
        }

        System.out.println(ans);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
