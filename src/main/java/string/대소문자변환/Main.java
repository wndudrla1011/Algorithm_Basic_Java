package string.대소문자변환;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            String s = input.substring(i, i + 1);
            char c = s.charAt(0);
            if (c >= 97 && c <= 122) //소문자
                result.append(s.toUpperCase());
            else //대문자
                result.append(s.toLowerCase());
        }

        System.out.println(result);
    }

}
