package string.p1_9;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().replaceAll("[^0-9]", "");
        System.out.println(Integer.parseInt(input));
    }

}
