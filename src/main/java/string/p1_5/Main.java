package string.p1_5;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        String input = br.readLine();
        int lt = 0, rt = input.length() - 1;

        char[] arr = input.toCharArray();
        while (lt < rt) {
            while (!Character.isAlphabetic(arr[lt])) lt++;
            while (!Character.isAlphabetic(arr[rt])) rt--;

            char tmp = arr[lt];
            arr[lt] = arr[rt];
            arr[rt] = tmp;

            lt++; rt--;
        }

        System.out.println(ans.append(arr));
    }

}
