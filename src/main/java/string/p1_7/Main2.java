package string.p1_7;

import java.io.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().toUpperCase();
        int len = input.length();

        System.out.println(checkPalindrome(input, len));
    }

    private static String checkPalindrome(String input, int len) {
        for (int i = 0; i < len / 2; i++) {
            if (input.charAt(i) != input.charAt(len - i - 1)) {
                return "NO";
            }
        }
        return "YES";
    }

}
