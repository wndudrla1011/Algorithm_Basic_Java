package string.p1_7;

import java.io.*;

public class Main3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String tmp = new StringBuilder(input).reverse().toString();

        System.out.println(input.equalsIgnoreCase(tmp) ? "YES" : "NO");
    }

}
