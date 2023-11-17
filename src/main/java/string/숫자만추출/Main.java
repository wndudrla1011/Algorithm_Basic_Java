package string.숫자만추출;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().replaceAll("[^0-9]", "");
        System.out.println(Integer.parseInt(input));
    }

}
