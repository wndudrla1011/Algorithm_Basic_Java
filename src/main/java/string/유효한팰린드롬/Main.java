package string.유효한팰린드롬;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().replaceAll("[^a-zA-Z]|[0-9]", "");
//        String input = br.readLine().toUpperCase().replaceAll("[^A-Z]", "");
        String tmp = new StringBuilder(input).reverse().toString();

        System.out.println(input.equalsIgnoreCase(tmp) ? "YES" : "NO");
    }

}
