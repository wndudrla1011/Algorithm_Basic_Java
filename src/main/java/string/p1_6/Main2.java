package string.p1_6;

import java.io.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (input.indexOf(input.charAt(i)) == i)
                ans.append(input.charAt(i));
        }

        System.out.println(ans);
    }

}
