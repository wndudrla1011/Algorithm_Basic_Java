package string.p1_10;

import java.io.*;
import java.util.StringTokenizer;

public class Main3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder ans = new StringBuilder();
        String s = st.nextToken();
        String t = st.nextToken();
        char[] arr = s.toCharArray();
        int ptr = 0; // current location

        while (ptr < s.length()) {
            int lt = ptr - 1, rt = ptr + 1; // search t from ptr
            if (arr[ptr] == t.charAt(0)) {
                ans.append(0).append(" ");
            } else {
                while (lt >= 0 && arr[lt] != t.charAt(0)) lt--;
                while (rt < s.length() && arr[rt] != t.charAt(0)) rt++;
                int left, right;
                left = (lt < 0) ? 100 : Math.abs(lt - ptr);
                right = (rt > s.length() - 1) ? 100 : Math.abs(rt - ptr);
                ans.append(Math.min(left, right)).append(" ");
            }
            ptr++;
        }

        System.out.println(ans);
    }

}
