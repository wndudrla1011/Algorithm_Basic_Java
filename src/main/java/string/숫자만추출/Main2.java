package string.숫자만추출;

import java.io.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int answer = 0;

        for (char c : input.toCharArray()) {
            if (c >= 48 && c <= 57)
                answer = answer * 10 + (c - 48);
        }

        System.out.println(answer);
    }

}
