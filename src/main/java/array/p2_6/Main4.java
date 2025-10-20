package array.p2_6;

import java.io.*;
import java.util.StringTokenizer;

public class Main4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb;
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb = new StringBuilder();
            sb.append(st.nextToken());
            int n = Integer.parseInt(String.valueOf(sb.reverse()));
            if (n == 1) continue;
            boolean flag = false;
            for (int j = n - 1; j > 1; j--) {
                if (n % j == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) ans.append(n).append(" ");
        }

        System.out.println(ans);
    }

}
