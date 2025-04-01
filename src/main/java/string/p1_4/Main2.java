package string.p1_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringBuilder tmp;
        String word;
        int cnt = Integer.parseInt(br.readLine());

        while (cnt-- > 0) {
            tmp = new StringBuilder();
            word = br.readLine();
            for (int i = word.length() - 1; i >= 0; i--) {
                tmp.append(word.charAt(i));
            }
            ans.append(tmp).append("\n");
        }

        System.out.println(ans);
    }

}
