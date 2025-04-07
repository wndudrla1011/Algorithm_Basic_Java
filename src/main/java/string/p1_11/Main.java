package string.p1_11;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder ans = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char cur, prev = ' ';
        int cnt = 1;

        for (int i = 1; i < input.length(); i++) {
            cur = input.charAt(i);
            prev = input.charAt(i - 1);
            if (prev == cur)
                cnt++;
            else {
                if (cnt == 1) ans.append(prev);
                else ans.append(prev).append(cnt);
                cnt = 1;
            }
        }

        if (cnt == 1) ans.append(prev);
        else ans.append(prev).append(cnt);

        System.out.println(ans);
    }

}
