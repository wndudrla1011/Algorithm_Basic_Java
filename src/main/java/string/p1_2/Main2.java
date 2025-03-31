package string.p1_2;

import java.io.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isLowerCase(c)) //소문자
                result.append(Character.toUpperCase(c));
            else //대문자
                result.append(Character.toLowerCase(c));
        }

        System.out.println(result);
    }

}
