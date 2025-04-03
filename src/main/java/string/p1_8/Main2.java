package string.p1_8;

import java.io.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        input = input.toUpperCase();
        char[] arr = input.toCharArray();

        System.out.println(validPalindrome(arr));
    }

    static String validPalindrome(char[] arr) {
        int lt = 0, rt = arr.length - 1;

        while (lt <= rt) {
            while (!Character.isAlphabetic(arr[lt])) lt++;
            while (!Character.isAlphabetic(arr[rt])) rt--;

            if (arr[lt] != arr[rt]) return "NO";

            lt++; rt--;
        }

        return "YES";
    }

}
