package string.단어뒤집기;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringBuilder word;
        int cnt = Integer.parseInt(br.readLine());

        while (cnt-- > 0) {
            word = new StringBuilder(br.readLine());
            ans.append(word.reverse()).append("\n");
        }

        System.out.println(ans);
    }

}
