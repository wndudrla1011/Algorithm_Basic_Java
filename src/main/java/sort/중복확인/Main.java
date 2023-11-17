package sort.중복확인;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        char ans = 'U';
        int N = readInt();
        int[] ch = new int[10000001];

        for (int i = 0; i < N; i++) {
            int n = readInt();
            if (ch[n] == 0) ch[n]++;
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
