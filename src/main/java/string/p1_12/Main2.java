package string.p1_12;

import java.io.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 암호 문자 개수
        String input = br.readLine(); // 암호
        char[] arr = input.toCharArray();
        StringBuilder ans = new StringBuilder();

        int cnt = 0;
        while (cnt < N) {
            String secret = ""; // 2진수
            for (int i = 0; i < 7; i++) {
                if (arr[7 * cnt + i] == '#') secret += 1;
                else secret += 0;
            }
            ans.append(Character.toChars(Integer.parseInt(secret, 2)));
            cnt++;
        }

        System.out.println(ans);
    }

}
