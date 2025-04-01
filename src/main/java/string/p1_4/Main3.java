package string.p1_4;

import java.io.*;

public class Main3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int cnt = Integer.parseInt(br.readLine());
        int lt, rt;

        while (cnt-- > 0) {
            char[] arr = br.readLine().toCharArray();
            lt = 0; rt = arr.length - 1;
            while (lt < rt) {
                char tmp = arr[lt];
                arr[lt] = arr[rt];
                arr[rt] = tmp;
                lt++; rt--;
            }
            ans.append(arr).append("\n");
        }

        System.out.println(ans);
    }

}
