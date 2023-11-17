package string.문자거리;

import java.io.*;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        char c = st.nextToken().charAt(0);
        int[] ans = new int[str.length()];
        int p = 1000;

        //왼쪽 c 로부터 떨어진 거리
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) p = 0;
            else p++;
            ans[i] = p;
        }

        p = 1000;

        //오른쪽 c 로부터 떨어진 거리
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == c) p = 0;
            else {
                p++;
                ans[i] = Math.min(ans[i], p); //기존 값보다 작으면
            }
        }

        for (int n : ans) {
            System.out.print(n + " ");
        }
    }

}
